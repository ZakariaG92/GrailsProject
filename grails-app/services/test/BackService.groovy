package test

import Test.Role
import Test.User
import Test.UserRole
import grails.gorm.transactions.Transactional
import org.springframework.web.multipart.MultipartFile

@Transactional
class BackService {

    def serviceMethod() {

    }

    def createUser (String username ,String password, String role){
        // Creation utilisateur
        def user = new User(username: username, password: password).save()

        if(user) {
            //Creation userRole
            if(role)
                UserRole.create(user, Role.get(role))
            return true
        } else {
            return false
        }
    }

    def listRole() {
        return Role.list()
    }

    def getUser(id) {
        return User.get(id)
    }

    def listUser() {
        return User.list()
    }

    def deleteUser(id) {
        def user =  User.get(id)
        def listRole = UserRole.findAllByUser(user)
        UserRole.deleteAll(listRole)
        user.delete()
    }


    //display Advertise
    def salesAd(){
        def ad = SaleAd.list();
        return  ad;
    }

    //deleteAdvertise
    def deleteAd(id) {
        def ad= SaleAd.get(id)
        ad.delete()
    }


    def createSalesAd(params, List illustrations, path){
        def ad = new SaleAd(title:params.title,descShort:params.descShort,descLong:params.descLong,price:params.price).save()
        println params
        print ad
        if(ad) {
            print "illu"
            if(!illustrations?.empty && illustrations?.size() != 0)  {
                println("FILLES")
                illustrations.forEach( {
                    def fileName = ad.id + "_" + it.originalFilename
                    def newFile = new File(path + fileName)
                    it.transferTo(newFile)
                    def illustration = new Illustration(filename: fileName)
                    ad.illustrations.add(illustration)
                })
            }
            return true
        } else {
            return false
        }
    }
}

package test

import Test.Role
import Test.User
import Test.UserRole
import grails.gorm.transactions.Transactional

@Transactional
class BackService {

    def serviceMethod() {

    }

    def createUser (String username ,String password, String role){
        // Creation utilisateur
        def user = new User(username: username, password: password).save()

        if(user) {
            //Creation userRole
            UserRole.create(user, Role.get(role))
            return true
        } else {
            return false
        }
    }

    def listRole() {
        return Role.list()
    }

    def listUser() {
        return User.list()
    }
}

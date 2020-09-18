package test

import Test.Role
import Test.User
import Test.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.MultipartFile


class BackController {
    SpringSecurityService springSecurityService
    BackService backService

    @Secured("ROLE_ADMIN")
    def index() {

    }

    @Secured("ROLE_ADMIN")
    def createUser() {
        def message = ""
        if (params.username!=null && params.password!=null){
            def username = params.username
            def password = params.password
            def role = params.role
            def created = backService.createUser(username, password, role)

            message = created ? "Creation reussite" : "Compte non créer !!"
        }
        [listRole: backService.listRole(), message: message]
    }
    @Secured("ROLE_ADMIN")
    def listUser() {
        [listUser: backService.listUser()]
    }
    @Secured("ROLE_ADMIN")
    def editUser() {
        [user: backService.getUser(params.id), listRole: backService.listRole()]
    }
    @Secured("ROLE_ADMIN")
    def deleteUser(){
        def id = params.id
        if(id) {
            backService.deleteUser(id)
        }
        redirect(action: "listUser")
    }

    def createSaleAd() {
    }

    //display Advertise
    def salesAd() {
        println(backService.salesAd())

        [listSalesAd: backService.salesAd()]
    }

    /*** Delete advertise ***/
   @Secured("ROLE_ADMIN")
    def deleteAd(){
        def id = params.id
        if(id) {
            backService.deleteAd(id)
        }

        redirect(action: "salesAd")
    }

    @Secured("ROLE_ADMIN")
    def createSalesAd() {
        def message = ""
        if (params.title!=null && params.descShort!=null && params.price!=null){
            List illustrations = request.getFiles('illustration')
            def projectPath = request.getSession().getServletContext().getRealPath("").replace("src\\main\\webapp\\", "")

            def created = backService.createSalesAd(params, illustrations, projectPath + "grails-app\\assets\\images\\salesAd\\")
            message = created ? "Creation reussite" : "Ad non créer !!"
        }

        [message: message]
    }
}

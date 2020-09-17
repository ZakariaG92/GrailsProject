package test

import Test.Role
import Test.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured


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
        println(session)
        [listRole: backService.listRole(), message: message]
    }

    def listUser() {
        [listUser: backService.listUser()]
    }
    def whoisuser(){
        def user = springSecurityService.getCurrentUser();

        if (user){println("le user est le : "+user)}
        [userwho: user]
    }
}

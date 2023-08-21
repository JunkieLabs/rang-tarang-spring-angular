package com.tarang.upload.ftp

import org.apache.ftpserver.ftplet.Authentication
import org.apache.ftpserver.ftplet.AuthenticationFailedException
import org.apache.ftpserver.ftplet.User
import org.apache.ftpserver.usermanager.ClearTextPasswordEncryptor
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication
import org.apache.ftpserver.usermanager.impl.AbstractUserManager

class CustomUserManager : AbstractUserManager("admin", ClearTextPasswordEncryptor()) {

    private val users = HashMap<String, User>()

    override fun getUserByName(username: String): User? {

        println("getUserByName 1 ${username} ${users[username]}")

        return users[username]
    }

    override fun getAllUserNames(): Array<String> {
        println("getAllUserNames 1")
        return users.keys.toTypedArray()
    }

    override fun delete(username: String) {
        users.remove(username)
    }

    override fun save(user: User) {
        users[user.name] = user
    }

    override fun doesExist(username: String): Boolean {
        println("getAllUserNames 1 ]] ${users.containsKey(username)}")

        return users.containsKey(username)
    }



    override fun authenticate(authentication: Authentication?): User {
               println("passow 223 ${authentication} ")

        if (authentication is UsernamePasswordAuthentication) {
//            val upauth = authentication
            println("passow 1 ${authentication.username} , ${authentication.password}")

            val user = getUserByName(authentication.username)
            if (user != null && passwordEncryptor.matches(authentication.password, user.password)) {
                println("passow")
                return user
            }
        }

         throw AuthenticationFailedException("Authentication failed")

    }

//    override fun authenticate(authentication: UsernamePasswordAuthentication): User? {
//
//            return null
//        }



//    override fun dispose() {
//        // Clean-up resources if needed
//    }
}
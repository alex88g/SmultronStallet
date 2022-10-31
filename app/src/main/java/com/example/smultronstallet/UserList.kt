package com.example.smultronstallet

class UserList() {
    var users = mutableListOf<User>()
  // init {
  //     createUsers()
  // }
    fun createUsers() {
        for(i in 1..100){
            var randomAge = (12..100).random()
            users.add(User("user$i","user${i}@user${i}mail.se",randomAge))
        }
    }
}
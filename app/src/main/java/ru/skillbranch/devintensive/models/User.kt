package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    var id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    init {

    }

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            var fullNameTrimmed = fullName?.trimIndent()
               return if (!fullNameTrimmed.isNullOrEmpty()) {
                   val (firstName, lastName) = Utils.parseFullName(fullName)
                   Builder()
                       .id("$lastId")
                       .firstName(firstName)
                       .lastName(lastName)
                       .build()
               } else {
                   User(id = "$lastId", firstName = null, lastName = null)
                   Builder()
                       .id("$lastId")
                       .firstName(null)
                       .lastName(null)
                       .build()
               }
        }
    }

    data class Builder(
        var id: String = "0",
        var firstName: String? = "",
        var lastName: String? = "",
        var avatar: String? = "",
        var rating: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline: Boolean = false
    ) {

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String?) = apply { this.firstName = firstName }
        fun lastName(lastName: String?) = apply { this.lastName = lastName }
        fun avatar(avatar: String) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date) = apply { this.lastVisit = lastVisit }
        fun isOnline(id: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }


}
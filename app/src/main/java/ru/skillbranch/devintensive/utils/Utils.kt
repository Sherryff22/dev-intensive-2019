package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.trimIndent()?.split(" ")

        var firstName = parts?.getOrNull(0)
        if (firstName == "" || firstName == " " ){
            firstName = null
        }
        var lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = null
        return when {
            firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> initials?.toUpperCase()
            firstName.isNullOrEmpty() || lastName.isNullOrEmpty() -> {
                initials = firstName + lastName
                initials.toUpperCase().substring(0, 1)
            }
            firstName.isNotEmpty() && lastName.isNotEmpty() -> firstName.substring(
                0,
                1
            ).toUpperCase() + lastName.substring(0, 1).toUpperCase()
            else -> initials?.toUpperCase()
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return payload
            .replace("а","a")
            .replace("б","b")
            .replace("в","v")
            .replace("г","g")
            .replace("д","d")
            .replace("е","e")
            .replace("ё","e")
            .replace("ж","zh")
            .replace("з","z")
            .replace("и","i")
            .replace("й","i")
            .replace("к","k")
            .replace("л","l")
            .replace("м","m")
            .replace("н","n")
            .replace("о","o")
            .replace("п","p")
            .replace("р","r")
            .replace("с","s")
            .replace("т","t")
            .replace("у","u")
            .replace("ф","f")
            .replace("х","h")
            .replace("ц","c")
            .replace("ч","ch")
            .replace("ш","sh")
            .replace("щ","sh'")
            .replace("ъ","")
            .replace("ы","i")
            .replace("ь","")
            .replace("э","e")
            .replace("ю","yu")
            .replace("я","ya")
            .replace("А","A")
            .replace("Б","B")
            .replace("В","V")
            .replace("Г","G")
            .replace("Д","D")
            .replace("Е","E")
            .replace("Ё","E")
            .replace("Ж","Zh")
            .replace("З","Z")
            .replace("И","I")
            .replace("Й","I")
            .replace("К","K")
            .replace("Л","L")
            .replace("М","M")
            .replace("Н","N")
            .replace("О","O")
            .replace("П","P")
            .replace("Р","R")
            .replace("С","S")
            .replace("Т","T")
            .replace("У","U")
            .replace("Ф","F")
            .replace("Х","H")
            .replace("Ц","C")
            .replace("Ч","Ch")
            .replace("Ш","Sh")
            .replace("Щ","Sh'")
            .replace("Ъ","")
            .replace("Ы","I")
            .replace("Ь","")
            .replace("Э","E")
            .replace("Ю","Yu")
            .replace("Я","Ya")
            .replace(" ", divider)
    }
}




package com.example.dataclasshomework.dataclass

/**
 * ДЗ:
 * В уроке про дата классы мы рассматривали, как можно вывести в терминал имя первого учителя из списка.
 * Давайте чуть усложним задачу и напишем фильтрацию преподавателей по опыту.
 *
 * У нас есть список учителей, нужно вывести список имен учителей, опыт которых больше 5 лет.
 * А если такого учителя нет, то нужно вывести текст: "Учитель с таким опытом не найден"
 *
 * Для выполнения задачи понадобится методы find и map из Kotlin.
 * Примеры использования можно изучить в официальной документации Kotlin:
 * 1. https://kotlinlang.ru/docs/collection-elements.html
 * 2. https://kotlinlang.ru/docs/map-operations.html
 */
fun main() {

    val languageList = listOf(
        Language("Kotlin"),
        Language("Java"),
    )

    val teacherList = listOf(
        Teacher("Николай", 37, 12, languageList),
        Teacher("Кирилл", 12, 12, languageList),
        Teacher("Анастасия", 7, 5, languageList),
        Teacher("Евгений", 2, 1, languageList)
    )

    val experiencedTeacher = getExperiencedTeacher(experience = 5, teacherList = teacherList)
    println(if (experiencedTeacher.isEmpty()) {
        "Учитель с таким опытом не найден"
    } else {
        experiencedTeacher
    })
}

/**
 * Метод поиска опытного учителя из списка
 */
private fun getExperiencedTeacher(experience: Int, teacherList: List<Teacher>): List<String> {
    return teacherList.filter { it.progExperience > experience }.map { it.name }
}

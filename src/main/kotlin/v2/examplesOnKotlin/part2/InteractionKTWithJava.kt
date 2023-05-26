package v2.examplesOnKotlin.part2

import v2.examplesOnJava.part1.PersonJava
import v2.examplesOnJava.part2.DBMockJava
import v2.examplesOnKotlin.part1.PersonKT

class InteractionKTWithJava {
    private val dbJava = DBMockJava()
    private val dbKT = DBMockKT()

    fun addPersonKT(person: PersonKT) {
        dbKT.insetPersonKT(person)
    }
    fun deletePerson(person: Any) {
        when (person) {
            is PersonKT -> dbKT.deletePersonKT(person)
            is PersonJava -> dbJava.deletePersonJava(person)
        }
    }
}
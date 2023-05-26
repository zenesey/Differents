package v2.examplesOnKotlin.part2

import v2.examplesOnJava.part1.PersonJava
import v2.examplesOnKotlin.part1.PersonKT

class DBMockKT: InterfaceForPersons {

    private var listKT = ArrayList<PersonKT>()
    private var listJava = ArrayList<PersonJava>()


    fun insetPersonKT(person: PersonKT){
        listKT.add(person)
    }
    fun deletePersonKT(person: PersonKT){
        listKT.remove(person)
    }
    fun insetPersonJava(person: PersonJava){
        listJava.add(person)
    }
    fun deletePersonJava(person: PersonJava){
        listJava.remove(person)
    }

    override fun printNameInstance() {
        println("DBMockKT")
    }
}

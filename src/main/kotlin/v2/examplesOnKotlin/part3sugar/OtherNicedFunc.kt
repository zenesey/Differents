package v2.examplesOnKotlin.part3sugar

import kotlinx.coroutines.coroutineScope
import v2.examplesOnKotlin.part1.PersonKT

fun main() {
//    OtherNicedFunc.turple()
//    funWhichCanBeCallEveryWhere()
//    OtherNicedFunc.generateSequenceEx()
    OtherNicedFunc.alsoEx()
}

object OtherNicedFunc {

    fun turple() {
        var str: String = "firstname surname middlename"
        var strSplit = str.split(" ")
        var (firstname, surname, middlename) = strSplit
        println(firstname)
        println(surname)
        println(middlename)

    }
    fun letEx() {
        var number = 5
        // let возвращает результат выполнения
        // it обьект на котором вызван метод
        var result = number.let {
            var str = "string"
            it * str.length
        }
    }

    fun applyEx() {
        // apply для изменения и донастройки обьекта
        // внутри можно обращаться напрямую к полям
        var person = PersonKT("Alex", 23)
        person.apply { lastName = "Tytichkin"  }
    }

    fun runEx() {
        //run условно блок кода результат которого можно вернуть
        //аналог let но без привязки к обьекту
        var result = run {
            var str = "Some string"
            str.uppercase()
        }
    }

    fun alsoEx() {
        //also выполнит блок кода но переменную i
        //никак не изменит
        var person = PersonKT("Alex", 23)

        var result = person.also {
            it.lastName = "someText"
            println(5)
        }
        println(result)
    }

    fun withEx() {
        //with дает возможность создать обьект на базе уже имеющегося
        //и изменить поля, но после того как отработает обьект person будет неизменным
        var person = PersonKT("Alex", 23)

        var result = with(person) {
            lastName = "Временное имя"
            "Person{name = $name age = $age, $lastName ${2 + 4} }"
        }
    }
        //generateSequence возможность генерировать обьекты на основе первого
    fun generateSequenceEx() = generateSequence(1 to 1) {
        it.second to it.second + it.first
    }.takeWhile { it.first > 10 }.map { it.first }.toList()


}



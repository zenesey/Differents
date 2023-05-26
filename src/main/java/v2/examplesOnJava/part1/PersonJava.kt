package v2.examplesOnJava.part1

import java.util.*

class PersonJava(var name: String, var age: Int) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as PersonJava
        return age == that.age && name == that.name
    }

    override fun hashCode(): Int {
        return Objects.hash(name, age)
    }

    override fun toString(): String {

        return "PersonJava{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}

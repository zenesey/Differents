package v2.examplesOnKotlin.part1

class PersonKT(val name: String, val age: Int) {
    //Геттеры и сеттеры по дефолту существуют
    var lastName: String
        get() = lastName
        set(value) {
            lastName = value
        }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }


}
//
//// по умолчанию equals hash toString
//data class DataClass(val name: String)

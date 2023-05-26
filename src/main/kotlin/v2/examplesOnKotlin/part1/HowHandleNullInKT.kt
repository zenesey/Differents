package v2.examplesOnKotlin.part1
fun main() {
    var npEonKotlin: NPEonKotlin = NPEonKotlin()
//    npEonKotlin.npe()
//    npEonKotlin.safetyCall()
    npEonKotlin.nonSafetyCall()
}

class NPEonKotlin {
    fun npe() {

        // Если не указать явно что может быть null(?) комилятор не позволит присовить null
        var neverGonnaBeenNPE: String = "null"
        var couldBeNPE: String? = null
    }

    fun safetyCall() {
        var str: String?
        //псвевдорандом для строки
        if ((0..10).random() > 5) str = null
        else str = "str not null"
        //Оператор safety-call(?.) присвоет значение если str не будет null
        //иначе присвоиться null
        var person = PersonKT("alex", 23)
        var strLength: PersonKT = person ?: forEx().apply { lastName = forEx().let { it.name } }
    }

    fun forEx(): PersonKT  {
        return PersonKT("Newname", 22)
    }

    fun nonSafetyCall() {
        var str: String?
        //псвевдорандом для строки
        if ((0..10).random() > 5) str = null
        else str = "str not null"
        //Оператор non safety-call(!!) присвоет значение если str не будет null
        //иначе будет выброшенно исключение NPE
        val nu11: String
        var strLength: Int = str!!.length
    }

    fun elvis() {
        var str: String?
        //псвевдорандом для строки
        if ((0..10).random() > 5) str = null
        else str = "str not null"
        //Оператор элвиса(?:) проверяет значение и если он являеться null присваивает
        //значение по умолчанию
        var strLength: Int = str?.length ?: -1

    }
}
package forexapleTests

import org.junit.jupiter.api.Test
import v2.examplesOnJava.part1.PersonJava
import v2.examplesOnJava.part2.InteractionJavaWithKT
import v2.examplesOnKotlin.part1.PersonKT
import v2.examplesOnKotlin.part2.InteractionKTWithJava

class InteractionJavaWithKTTest {
    private var interactionJava = InteractionJavaWithKT()
    private var interactionKT = InteractionKTWithJava()

    private fun createPersonKT(iter: Int): List<PersonKT> {
        var listPersonKT = ArrayList<PersonKT>()
        for (i in 0..iter) {
            listPersonKT.add(PersonKT("Person in KT which age == $i", i))
        }
        return listPersonKT
    }

    private fun createPersonJava(iter: Int) =
        generateSequence(0) { it + 1 }
            .take(iter)
            .map { PersonJava("Person in Java which age = $it", it) }
            .toList()

    @Test
    fun `show how this simple worked`() {
        var listKt = createPersonKT(5)
        var listJava = createPersonJava(5)

        listKt.forEach { interactionKT.addPersonKT(it) }
        listJava.forEach { interactionJava.addPersonJava(it) }

        listKt.forEach { interactionKT.deletePerson(it) }
        listJava.forEach { interactionJava.deletePerson(it) }


    }
}


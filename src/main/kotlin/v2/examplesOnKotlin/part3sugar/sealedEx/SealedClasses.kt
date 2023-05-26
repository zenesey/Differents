package v2.examplesOnKotlin.part3sugar.sealedEx

sealed class SealedClasses {
    data class Dog(val name: String) : SealedClasses()
    data class Cat(val name: String) : SealedClasses()
    data class Bird(val name: String) : SealedClasses()
    object Nothing : SealedClasses() {
        fun staticMethod() {
            println()
        }
    }
}

fun showHowThisWork() {
    val dog = SealedClasses.Dog("dog")
    val cat = SealedClasses.Cat("cat")
    val bird = SealedClasses.Bird("bird")
    differentWork(dog)
    differentWork(cat)
    differentWork(bird)
}

fun differentWork(animal: SealedClasses){
    when(animal) {
        is SealedClasses.Dog -> println(animal.name)
        is SealedClasses.Cat -> println(animal.name)
        is SealedClasses.Bird -> println(animal.name)
        is SealedClasses.Nothing -> SealedClasses.Nothing.staticMethod()
        else -> {}
    }

}
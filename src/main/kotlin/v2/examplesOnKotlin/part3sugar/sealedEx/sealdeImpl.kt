package v2.examplesOnKotlin.part3sugar.sealedEx

import java.lang.Exception
import java.util.Objects


data class SealedErrorImpl(var errorMessageString: String) : SealedInterface
data class SealedSuccessImpl(var successMessageString: String) : SealedInterface

fun exampleSealed(any: SealedInterface) {

    when (any) {
        is SealedErrorImpl -> println("SealedErrorImpl")
        is SealedSuccessImpl -> println("SealedSuccessImpl")
    else -> println()
//        else -> println()
    }
}


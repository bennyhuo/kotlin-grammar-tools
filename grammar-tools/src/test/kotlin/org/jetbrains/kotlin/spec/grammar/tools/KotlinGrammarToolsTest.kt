package org.jetbrains.kotlin.spec.grammar.tools

import org.junit.Test

/**
 * Created by benny.
 */
class KotlinGrammarToolsTest {



    @Test
    fun test() {
        val tokens = tokenizeKotlinCode("""
            interface Ignore
            interface Base: Ignore, Parcelable

            data class Location0(var lat: Double, var lng: Double): Base
            class Location1(var lat: Double, var lng: Double)
            data
            class Location2(var lat: Double, var lng: Double)
            final data class Location3(var lat: Double, var lng: Double): Ignore
            data private class Location4(var lat: Double, var lng: Double)
            @Parcelize data class Location5(var lat: Double, var lng: Double)
            @Parcelize class Location6(var lat: Double, var lng: Double)
            
        """.trimIndent())
        val parseTree = parseKotlinCode(tokens)
        // or just `val parseTree = parseKotlinCode("val x = foo() + 10;")`

        println(parseTree)
    }


}
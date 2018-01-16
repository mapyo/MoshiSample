package com.mapyo.moshisample

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

sealed class Animal(val name: String) {
    class Cat : Animal("cat")
}


class ExampleUnitTest {
    @Test
    fun moshi() {
        val cat = Animal.Cat()

        val moshiCatJson = Moshi.Builder().build()
                .adapter(Animal.Cat::class.java).toJson(cat)
        Assertions.assertThat(moshiCatJson).isEqualTo("{\"name\":\"cat\"}")

        val moshiKotlinCatJson = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                .adapter(Animal.Cat::class.java).toJson(cat)
        Assertions.assertThat(moshiKotlinCatJson).isEqualTo("{}")
    }
}

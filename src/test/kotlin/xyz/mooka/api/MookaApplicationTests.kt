package xyz.mooka.api

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MookaApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun whenAdding1and3_thenAnswerIs4() {
        println("here test")
        Assertions.assertEquals(4, 1 + 3)
    }

}

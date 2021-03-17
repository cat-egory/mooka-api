package xyz.mooka.api

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.mooka.api.gateway.NaverApi

@SpringBootTest
class MookaApplicationTests(
    @Autowired private var naverApi: NaverApi
) {

    @Test
    fun contextLoads() {
    }


    @Test
    fun whenAdding1and3_thenAnswerIs4() {
        println("here test")
        Assertions.assertEquals(4, 1 + 3)
    }

    @Test
    fun callNaverApi() {
        naverApi.getMovieList("페르소나")
    }

}

package xyz.mooka.api.out

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@Service
class NaverApi(
    private val restTemplate: RestTemplate
) {
    fun getTest(name: String) {
        val ref = String::class.java
//        restTemplate.getForObject("/teams?name=$name", ref)
        val list =
            restTemplate.getForObject("/v1/search/movie.json?query=페르소나&display=10&start=1&genre=1", ref)
        println(list)
    }


//    fun getMovieList(): Any {
//    }
}

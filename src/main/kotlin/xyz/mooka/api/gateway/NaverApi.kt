package xyz.mooka.api.gateway

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class NaverApi(
    private val restTemplate: RestTemplate
) {
    fun getMovieList(name: String) {
        val ref = String::class.java
        val list =
            restTemplate.getForObject("/v1/search/movie.json?query=$name&display=10&start=1&genre=1", ref)
        println(list)
    }


}

package xyz.mooka.api.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class Configuration {

    @Value("\${api.naver.clientId}")
    val naverClientId: String = ""

    @Value("\${api.naver.secret}")
    val naverSecret: String = ""

    @Bean
    fun restTemplate(objectMapper: ObjectMapper): RestTemplate {
        return RestTemplateBuilder()
            .rootUri("https://openapi.naver.com")
            .defaultHeader("X-Naver-Client-Id", naverClientId)
            .defaultHeader("X-Naver-Client-Secret", naverSecret)
            .setConnectTimeout(Duration.ofSeconds(10))
            .additionalMessageConverters()
            .build()
    }
}

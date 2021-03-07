package xyz.mooka.api.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class Configuration {

    @Bean
    fun restTemplate(objectMapper: ObjectMapper): RestTemplate {
        return RestTemplateBuilder()
            .rootUri("https://openapi.naver.com")
            .setConnectTimeout(Duration.ofSeconds(10))
            .additionalMessageConverters()
            .build()
    }
}

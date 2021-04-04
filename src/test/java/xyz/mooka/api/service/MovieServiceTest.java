package xyz.mooka.api.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import xyz.mooka.api.gateway.NaverGateway;

@SpringBootTest
public class MovieServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NaverGateway naverGateway;

    @Test
    public void sample() {
        logger.info("sample");
    }

    @Test
    public void firstNaver() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://openapi.naver.com")
                .defaultHeader("X-Naver-Client-Id", "테스트아이")
                .defaultHeader("X-Naver-Client-Secret", "비번")
                .build();

        Mono<String> stringMono = webClient.mutate()
                .build()
                .get()
                .uri("/v1/search/movie.json?query=$name&display=10&start=1&genre=1")
                .retrieve()
                .bodyToMono(String.class);

        logger.info("------");
        stringMono.blockOptional().ifPresent(logger::info);
    }

    @Test
    public void getNaverInfo() {
        naverGateway.showNaverInfo();
    }

    @Test
    public void getNaverMovieLIst() {
        logger.info(naverGateway.get("/v1/search/movie.json?query=$name&display=10&start=1&genre=1"));
    }

}

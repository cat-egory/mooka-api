package xyz.mooka.api.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import xyz.mooka.api.dto.NaverMovieDto;
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
    public void getNaverInfo() {
        naverGateway.showNaverInfo();
    }

    @Test
    public void getNaverMovieList() {
        logger.info(naverGateway.get("/v1/search/movie.json?query=$name&display=10&start=1&genre=1"));
    }

    @Test
    public void buildNaverMovieDto() {
        NaverMovieDto movieDto = NaverMovieDto.builder()
                .title("아들의 이름으로")
                .link("https://movie.naver.com/movie/bi/mi/basic.nhn?code=195694")
                .image("https://ssl.pstatic.net/imgmovie/mdi/mit110/1956/195694_P01_150445.jpg")
                .subtitle("In the Name of the Son")
                .pubDate("2020")
                .director("이정국|")
                .actor("안성기|박근형|윤유선|")
                .userRating("0.00")
                .build();
                //"title": "아들의 이름으로",
        // "link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=195694",
        // "image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1956/195694_P01_150445.jpg",
        // "subtitle": "In the Name of the Son",
        // "pubDate": "2020", "director": "이정국|",
        // "actor": "안성기|박근형|윤유선|",
        // "userRating": "0.00"

        logger.info("movie dto:" + movieDto.toString());
    }

}

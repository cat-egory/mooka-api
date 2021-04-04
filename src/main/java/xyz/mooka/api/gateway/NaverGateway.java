package xyz.mooka.api.gateway;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

@Service
public class NaverGateway {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static WebClient webClient;

    @Value("${api.naver.clientId}")
    String naverClientId;

    @Value("${api.naver.naverSecret}")
    String naverSecret;

    @Autowired
    NaverGateway() {
        webClient =
            WebClient
                .builder()
                .baseUrl("https://openapi.naver.com")
                .defaultHeader("X-Naver-Client-Id", naverClientId)
                .defaultHeader("X-Naver-Client-Secret", naverSecret)
                .build();
    }

    public String get(String url) {
        try {
            Mono<String> stringMono = webClient.mutate().build().get().uri(url).retrieve().bodyToMono(String.class);
            Optional<String> stringOptional = stringMono.blockOptional();
            if (stringOptional.isPresent()) {
                return stringOptional.get();
                //TODO Exception Handling
            }
        } catch (WebClientException we) {
            logger.error(we.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public void showNaverInfo() {
        logger.info(naverClientId);
    }
}

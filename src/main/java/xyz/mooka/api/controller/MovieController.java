package xyz.mooka.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mooka.api.gateway.NaverGateway;

@RestController
public class MovieController extends BaseController {

    private NaverGateway naverGateway;

    @Autowired
    MovieController(NaverGateway naverGateway) {
        this.naverGateway = naverGateway;
    }

    //Todo remote gateway and add movieService

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("api/movie")
    public ResponseEntity<?> getMovieList() {
        logger.info(naverGateway.get("/v1/search/movie.json?query=$name&display=10&start=1&genre=1"));
        return new ResponseEntity<>("here~", HttpStatus.OK);
    }
}

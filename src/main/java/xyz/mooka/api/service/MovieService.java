package xyz.mooka.api.service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mooka.api.gateway.NaverGateway;

@Service
public class MovieService {

    private NaverGateway naverGateway;

//    @Autowired
//    MovieService(NaverGateway naverGateway) {
//        this.naverGateway = naverGateway;
//    }

    public String getMovieList() {
        return "";
    }
}

package co.com.aranda.ps3.store.crosscuting.persistence.requestgame.impl;

import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity.RequestGame;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.repository.RequestGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RequestGameImpl {
    @Autowired
    private RequestGameRepository gameRepository;

    public RequestGame saveRequestGame(RequestGame requestGame) {
        return this.gameRepository.save(requestGame);
    }

    public RequestGame updateRequestGame(RequestGame requestGame) {
        return this.saveRequestGame(requestGame);
    }

    public Optional<RequestGame> getRequestGameById(Long id) {
        return this.gameRepository.findById(id);
    }

    public List<RequestGame> getListRequestGame() {
        return this.gameRepository.findAll();
    }


}

package co.com.aranda.ps3.store.crosscuting.persistence.game.impl;

import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
import co.com.aranda.ps3.store.crosscuting.domain.traslate.TranslateGame;
import co.com.aranda.ps3.store.crosscuting.persistence.game.entity.Game;
import co.com.aranda.ps3.store.crosscuting.persistence.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameImpl {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private TranslateGame translateGame;

    public GameDto saveGame(Game gameDto) {
        return this.translateGame
                .translateToDto(this.gameRepository.save(gameDto));
    }

    public List<Game> getListGames(){
        return this.gameRepository.findAll();
    }

    public GameDto getGameById(Long id) {
        Game game = this.gameRepository.findById(id).orElse(null);
        return game != null ? this.translateGame
                .translateToDto(game) : null;
    }

    public void deleteGame(long gameId) {
        this.gameRepository.deleteById(gameId);
    }

}

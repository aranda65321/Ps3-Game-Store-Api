package co.com.aranda.ps3.store.modules.game.providers;

import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
import co.com.aranda.ps3.store.crosscuting.domain.traslate.TranslateGame;
import co.com.aranda.ps3.store.crosscuting.persistence.game.entity.Game;
import co.com.aranda.ps3.store.crosscuting.persistence.game.impl.GameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameProvider {
    @Autowired
    private GameImpl gameImpl;
    @Autowired
    private TranslateGame translateGame;

    public List<Game> getListGames(){
        return this.gameImpl.getListGames();
    }
    public Optional<GameDto> getGameById(Long id) {
        return Optional.ofNullable(this.gameImpl.getGameById(id));
    }

    public Optional<GameDto> saveGame(GameDto gameDto) {
        Game game = this.translateGame.translateToEntity(gameDto);
        return Optional.of(this.gameImpl.saveGame(game));
    }

    public boolean deleteGame(long id) {
        try {
            this.gameImpl.deleteGame(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validGameRequest(final GameDto gameDto) {
        if (gameDto == null || gameDto.getName() == null || gameDto.getDescription() == null
                || gameDto.getFilePassword() == null || gameDto.getLanguage() == null
                || gameDto.getNumberId() == null || gameDto.getRegion() == null || gameDto.getServers() == null
                || gameDto.getSize() == null || gameDto.getTrailerLink() == null || gameDto.getType() == null
                || gameDto.getUrlImage() == null) {
            return false;
        }
        return true;
    }
}

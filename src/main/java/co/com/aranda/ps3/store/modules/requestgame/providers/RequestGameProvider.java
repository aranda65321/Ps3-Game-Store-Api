package co.com.aranda.ps3.store.modules.requestgame.providers;

import co.com.aranda.ps3.store.crosscuting.domain.dto.RequestGameDto;
import co.com.aranda.ps3.store.crosscuting.domain.enums.StatusRequestGame;
import co.com.aranda.ps3.store.crosscuting.domain.traslate.TranslateRequestGame;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity.RequestGame;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.impl.RequestGameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class RequestGameProvider {

    @Autowired
    private RequestGameImpl requestGameImpl;
    @Autowired
    private TranslateRequestGame requestGameTranslate;

    public List<RequestGame> getListRequestGame() {
        return this.requestGameImpl.getListRequestGame();
    }

    public Optional<RequestGameDto> getRequestGameById(Long id) {
        Optional<RequestGame> game = this.requestGameImpl.getRequestGameById(id);
        if (game.isPresent()) {
            return Optional.of(this.requestGameTranslate.translateToDto(game.get()));
        }
        return Optional.empty();
    }

    public Optional<RequestGameDto> saveRequestGame(String gameName) {
        RequestGame requestGame = RequestGame.builder()
                .id(0L)
                .name(gameName)
                .status(StatusRequestGame.CREATE.getLabel())
                .creationDate(new Date())
                .build();
        return Optional.ofNullable(
                this.requestGameTranslate.translateToDto(this.requestGameImpl.saveRequestGame(requestGame)));
    }

    public Optional<RequestGameDto> saveRequestGame(RequestGameDto requestGameDto) {
        return Optional.of(
                this.requestGameTranslate.translateToDto(this.requestGameImpl.saveRequestGame(
                        this.requestGameTranslate.translateToEntity(requestGameDto)
                )));
    }

    public Optional<RequestGameDto> updateRequestGame(RequestGameDto requestGameDto) {
        return Optional.of(
                this.requestGameTranslate.translateToDto(
                        this.requestGameImpl.updateRequestGame(
                                this.requestGameTranslate.translateToEntity(requestGameDto))));

    }

}

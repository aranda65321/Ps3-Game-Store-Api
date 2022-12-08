package co.com.aranda.ps3.store.modules.requestgame.providers;

import co.com.aranda.ps3.store.crosscuting.domain.dto.RequestGameDto;
import co.com.aranda.ps3.store.crosscuting.domain.traslate.TranslateRequestGame;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity.RequestGame;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.impl.RequestGameImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RequestGameProvider {

    @Autowired
    private RequestGameImpl requestGameImpl;
    @Autowired
    private TranslateRequestGame requestGameTranslate;


    public Optional<RequestGameDto> getRequestGameById(Long id) {
        Optional<RequestGame> game = this.requestGameImpl.getRequestGameById(id);
        if (game.isPresent()) {
            return Optional.of(this.requestGameTranslate.translateToDto(game.get()));
        }
        return Optional.empty();
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

package co.com.aranda.ps3.store.crosscuting.domain.traslate;


import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
import co.com.aranda.ps3.store.crosscuting.domain.pattern.Translator;
import co.com.aranda.ps3.store.crosscuting.persistence.game.entity.Game;

public class TranslateGame implements Translator<Game, GameDto> {
    @Override
    public GameDto translate(Game input) {
        return GameDto.builder()
                .name(input.getName())
                .language(input.getLanguage())
                .size(input.getSize())
                .type(input.getType())
                .region(input.getRegion())
                .numberId(input.getNumberId())
                .servers(input.getServers())
                .filePassword(input.getFilePassword())
                .description(input.getDescription())
                .trailerLink(input.getTrailerLink())
                .build();
    }
}

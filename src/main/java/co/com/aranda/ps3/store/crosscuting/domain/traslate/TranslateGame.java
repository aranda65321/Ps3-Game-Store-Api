package co.com.aranda.ps3.store.crosscuting.domain.traslate;


import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
import co.com.aranda.ps3.store.crosscuting.domain.pattern.Translator;
import co.com.aranda.ps3.store.crosscuting.persistence.game.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class TranslateGame implements Translator<Game, GameDto> {
    @Override
    public Game translateToEntity(GameDto input) {
        return Game.builder()
                .id(input.getId())
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
                .urlImage(input.getUrlImage())
                .build();
    }

    @Override
    public GameDto translateToDto(Game input) {
        return GameDto.builder()
                .id(input.getId())
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
                .urlImage(input.getUrlImage())
                .build();
    }
}

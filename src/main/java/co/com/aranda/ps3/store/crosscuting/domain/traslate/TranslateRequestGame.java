package co.com.aranda.ps3.store.crosscuting.domain.traslate;

import co.com.aranda.ps3.store.crosscuting.domain.dto.RequestGameDto;
import co.com.aranda.ps3.store.crosscuting.domain.pattern.Translator;
import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity.RequestGame;

public class TranslateRequestGame implements Translator<RequestGame, RequestGameDto> {
    @Override
    public RequestGame translateToEntity(RequestGameDto input) {
        RequestGame.builder()
                .id(input.getId())
                .name(input.getName())
                .creationDate(input.getCreationDate())
                .status(input.getStatus())
                .build();
        return null;
    }

    @Override
    public RequestGameDto translateToDto(RequestGame input) {
        RequestGameDto.builder()
                .id(input.getId())
                .name(input.getName())
                .creationDate(input.getCreationDate())
                .status(input.getStatus())
                .build();
        return null;
    }
}

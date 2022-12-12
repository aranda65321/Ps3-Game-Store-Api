package co.com.aranda.ps3.store.modules.requestgame.api;

import co.com.aranda.ps3.store.crosscuting.domain.dto.RequestGameDto;
import co.com.aranda.ps3.store.crosscuting.domain.enums.GlobalMessages;
import co.com.aranda.ps3.store.modules.requestgame.providers.RequestGameProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/request-games")
@CrossOrigin("*")
@Log4j2
public class RequestGameController {
    @Autowired
    private RequestGameProvider requestGameProvider;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getGameById(@RequestParam long idGame) {
        Optional<RequestGameDto> requestGame = this.requestGameProvider.getRequestGameById(idGame);
        if (requestGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, requestGame.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity.badRequest()
                .body(this.getApiResponse(false, null,
                        GlobalMessages.NOT_FOUND_REQUEST_GAME.getLabel() + idGame));
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getListRequestGames() {
        return ResponseEntity.ok(this.getApiResponse(
                true,this.requestGameProvider.getListRequestGame(),
                GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createNewRequestGame(@RequestParam String gameName) {
        log.info(GlobalMessages.CREATING_GAME.getLabel());
        Optional<RequestGameDto> saveRequestGame = this.requestGameProvider.saveRequestGame(gameName);
        if (saveRequestGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveRequestGame.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.COULD_NOT_UPDATE_REQUEST_GAME.getLabel()));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> updateRequestGame(@RequestBody RequestGameDto requestGameDto) {
        log.info(GlobalMessages.UPDATING_REQUEST_GAME.getLabel());
        Optional<RequestGameDto> saveRequestGame = this.requestGameProvider.saveRequestGame(requestGameDto);
        if (saveRequestGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveRequestGame.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(
                        this.getApiResponse(false, null,
                                GlobalMessages.COULD_NOT_UPDATE_REQUEST_GAME.getLabel() + requestGameDto.getId()));
    }

    private Map<String, Object> getApiResponse(boolean isOk, Object game, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put(GlobalMessages.STATE.getLabel(), isOk ? "OK" : "ERROR");
        response.put(GlobalMessages.CONTENT.getLabel(), game);
        response.put(GlobalMessages.MESSAGES.getLabel(), mensaje);
        return response;
    }
}

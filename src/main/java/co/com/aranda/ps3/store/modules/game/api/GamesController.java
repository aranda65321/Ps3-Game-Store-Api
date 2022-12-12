package co.com.aranda.ps3.store.modules.game.api;

import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
import co.com.aranda.ps3.store.crosscuting.domain.enums.GlobalMessages;
import co.com.aranda.ps3.store.modules.game.providers.GameProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
@Log4j2
public class GamesController {
    @Autowired
    private GameProvider gameProvider;

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createNewGame(@RequestBody GameDto game) {
        log.info(GlobalMessages.CREATING_GAME.getLabel());
        if (this.gameProvider.validGameRequest(game)) {
            Optional<GameDto> saveGame = this.gameProvider.saveGame(game);
            if (saveGame.isPresent()) {
                return ResponseEntity.ok(this.getApiResponse(true, saveGame.get(),
                        GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
            }
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.ERROR_CREATING_GAME.getLabel() ));
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getListGames() {
        return ResponseEntity.ok(this.getApiResponse(true,this.gameProvider.getListGames(),
                GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getGameById(@RequestParam long idGame) {
        Optional<GameDto> game = this.gameProvider.getGameById(idGame);
        if (game.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, game.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity.badRequest()
                .body(this.getApiResponse(false, null,
                        GlobalMessages.NOT_FOUND_GAME.getLabel() + idGame));
    }

    @DeleteMapping("/")
    public ResponseEntity<Map<String, Object>> deleteGame(@RequestParam long idGame) {
        if (this.gameProvider.deleteGame(idGame)) {
            return ResponseEntity.ok(this.getApiResponse(true, null,
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.NOT_FOUND_REQUEST_GAME.getLabel() + idGame));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> updateGame(@RequestBody GameDto game) {
        log.info(GlobalMessages.UPDATING_GAME.getLabel());
        if (this.gameProvider.validGameRequest(game)) {
            Optional<GameDto> saveGame = this.gameProvider.saveGame(game);
            if (saveGame.isPresent()) {
                return ResponseEntity.ok(this.getApiResponse(true, saveGame.get(),
                        GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
            }
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.ERROR_UPDATING_GAME.getLabel() + game.getId()));
    }

    private Map<String, Object> getApiResponse(boolean isOk, Object game, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put("Estado", isOk ? "OK" : "ERROR");
        response.put("Content", game);
        response.put("Mensaje", mensaje);
        return response;
    }

}

package co.com.aranda.ps3.store.modules.game.api;

import co.com.aranda.ps3.store.crosscuting.domain.dto.GameDto;
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

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getGameById(@RequestParam long idGame) {
        Optional<GameDto> game = this.gameProvider.getGameById(idGame);
        if (game.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, game.get(), "Proceso Exitoso"));
        }
        return ResponseEntity.badRequest()
                .body(this.getApiResponse(false, null, "No se encontro el juego con el id: " + idGame));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createNewGame(@RequestBody GameDto game) {
        log.info("Creando Game");
        if (this.gameProvider.validGameRequest(game)) {
            Optional<GameDto> saveGame = this.gameProvider.saveGame(game);
            if (saveGame.isPresent()) {
                return ResponseEntity.ok(this.getApiResponse(true, saveGame.get(), "Proceso Exitoso"));
            }
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null, "No se pudo crear el juego"));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> deleteGame(@RequestParam long idGame) {
        if (this.gameProvider.deleteGame(idGame)) {
            return ResponseEntity.ok(this.getApiResponse(true, null, "Proceso Exitoso"));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null, "No se encontro juego" +
                        " con el id: " + idGame));
    }

    @PatchMapping("/")
    public ResponseEntity<Map<String, Object>> updateGame(@RequestBody GameDto game) {
        log.info("Actualizando Game");
        if (this.gameProvider.validGameRequest(game)) {
            Optional<GameDto> saveGame = this.gameProvider.saveGame(game);
            if (saveGame.isPresent()) {
                return ResponseEntity.ok(this.getApiResponse(true, saveGame.get(), "Proceso Exitoso"));
            }
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null, "No se pudo actualizar el juego"
                        + " con id" + game.getId()));
    }

    private Map<String, Object> getApiResponse(boolean isOk, GameDto game, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put("Estado", isOk ? "OK" : "ERROR");
        response.put("Content", game);
        response.put("Mensaje", mensaje);
        return response;
    }

}

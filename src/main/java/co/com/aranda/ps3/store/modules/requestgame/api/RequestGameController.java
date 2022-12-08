package co.com.aranda.ps3.store.modules.requestgame.api;

import co.com.aranda.ps3.store.crosscuting.domain.dto.RequestGameDto;
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
            return ResponseEntity.ok(this.getApiResponse(true, requestGame.get(), "Proceso Exitoso"));
        }
        return ResponseEntity.badRequest()
                .body(this.getApiResponse(false, null, "No se encontro la solicitud " +
                        "con el id: " + idGame));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createNewRequestGame(@RequestBody RequestGameDto requestGameDto) {
        log.info("Creando Game");
        Optional<RequestGameDto> saveRequestGame = this.requestGameProvider.saveRequestGame(requestGameDto);
        if (saveRequestGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveRequestGame.get(), "Proceso Exitoso"));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null, "No se pudo crear el solicitud"));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> updateRequestGame(@RequestBody RequestGameDto requestGameDto) {
        log.info("Actualizando Solicitud ");
        Optional<RequestGameDto> saveRequestGame = this.requestGameProvider.saveRequestGame(requestGameDto);
        if (saveRequestGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveRequestGame.get(), "Proceso Exitoso"));
        }
        return ResponseEntity
                .badRequest().body(
                        this.getApiResponse(false, null,
                                "No se pudo actualizar la solicitud con id: " + requestGameDto.getId()));
    }

    private Map<String, Object> getApiResponse(boolean isOk, RequestGameDto game, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put("Estado", isOk ? "OK" : "ERROR");
        response.put("Content", game);
        response.put("Mensaje", mensaje);
        return response;
    }
}

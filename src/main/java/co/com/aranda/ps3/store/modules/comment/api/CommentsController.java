package co.com.aranda.ps3.store.modules.comment.api;

import co.com.aranda.ps3.store.crosscuting.domain.dto.CommentDto;
import co.com.aranda.ps3.store.crosscuting.domain.enums.GlobalMessages;
import co.com.aranda.ps3.store.modules.comment.provider.CommentProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
@Log4j2
public class CommentsController {

    @Autowired
    private CommentProvider commentProvider;

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createNewGame(@RequestBody CommentDto comment) {
        log.info(GlobalMessages.CREATING_GAME.getLabel());
        Optional<CommentDto> saveComment = this.commentProvider.saveComment(comment);
        if (saveComment.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveComment.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.ERROR_CREATING_GAME.getLabel()));
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getListGames() {
        return ResponseEntity.ok(this.getApiResponse(true, this.commentProvider.getListComments(),
                GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getGameById(@RequestParam long idComment) {
        Optional<CommentDto> comment = this.commentProvider.getCommentById(idComment);
        if (comment.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, comment.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity.badRequest()
                .body(this.getApiResponse(false, null,
                        GlobalMessages.NOT_FOUND_GAME.getLabel() + idComment));
    }

    @DeleteMapping("/")
    public ResponseEntity<Map<String, Object>> deleteGame(@RequestParam long idComment) {
        if (this.commentProvider.deleteComment(idComment)) {
            return ResponseEntity.ok(this.getApiResponse(true, null,
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.NOT_FOUND_REQUEST_GAME.getLabel() + idComment));
    }

    @PutMapping("/")
    public ResponseEntity<Map<String, Object>> updateGame(@RequestBody CommentDto comment) {
        log.info(GlobalMessages.UPDATING_GAME.getLabel());
        Optional<CommentDto> saveGame = this.commentProvider.saveComment(comment);
        if (saveGame.isPresent()) {
            return ResponseEntity.ok(this.getApiResponse(true, saveGame.get(),
                    GlobalMessages.PROCESS_SUCCESSFULL.getLabel()));
        }
        return ResponseEntity
                .badRequest().body(this.getApiResponse(false, null,
                        GlobalMessages.ERROR_UPDATING_GAME.getLabel() + comment.getId()));
    }

    private Map<String, Object> getApiResponse(boolean isOk, Object game, String mensaje) {
        Map<String, Object> response = new HashMap<>();
        response.put("Estado", isOk ? "OK" : "ERROR");
        response.put("Content", game);
        response.put("Mensaje", mensaje);
        return response;
    }


}

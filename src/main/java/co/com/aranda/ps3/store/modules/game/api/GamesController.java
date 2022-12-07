package co.com.aranda.ps3.store.modules.game.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")
@Log4j2
public class GamesController {

    @PostMapping("/")
    public String createNewGame(){
        log.info("Holaaaaaaa");
        return "Holaaaaaaa";
    }

}

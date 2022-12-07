package co.com.aranda.ps3.store.crosscuting.persistence.game.impl;

import co.com.aranda.ps3.store.crosscuting.persistence.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameImpl {
    @Autowired
    private GameRepository gameRepository;

    public void saveGame(){
        
    }

}

package co.com.aranda.ps3.store.crosscuting.persistence.game.repository;

import co.com.aranda.ps3.store.crosscuting.persistence.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}

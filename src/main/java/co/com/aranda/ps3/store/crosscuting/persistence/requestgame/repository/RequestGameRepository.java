package co.com.aranda.ps3.store.crosscuting.persistence.requestgame.repository;

import co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity.RequestGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestGameRepository extends JpaRepository<RequestGame, Long> {
}

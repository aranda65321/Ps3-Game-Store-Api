package co.com.aranda.ps3.store.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"co.com.aranda.ps3.store"
})
@EnableJpaRepositories(basePackages = {
		"co.com.aranda.ps3.store.crosscuting.persistence.game.repository",
		"co.com.aranda.ps3.store.crosscuting.persistence.comment.repository",
		"co.com.aranda.ps3.store.crosscuting.persistence.requestgame.repository"
})
@EntityScan(basePackages = {
		"co.com.aranda.ps3.store.crosscuting.persistence.game.entity",
		"co.com.aranda.ps3.store.crosscuting.persistence.comment.entity",
		"co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity"
})
public class Ps3GameStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ps3GameStoreApiApplication.class, args);
	}

}

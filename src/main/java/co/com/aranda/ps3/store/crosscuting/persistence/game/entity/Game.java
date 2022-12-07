package co.com.aranda.ps3.store.crosscuting.persistence.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "REGION")
    private String region;

    @Column(name = "NUMBER_ID")
    private String numberId;

    @Column(name = "SERVERS")
    private String servers;

    @Column(name = "FILE_PASSWORD")
    private String filePassword;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TRAILER_LINK")
    private String trailerLink;
}

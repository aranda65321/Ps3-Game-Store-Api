package co.com.aranda.ps3.store.crosscuting.persistence.requestgame.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity()
@Table(name = "SOLICITUDES_JUEGOS")
public class RequestGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "STATUS")
    private String status;
}

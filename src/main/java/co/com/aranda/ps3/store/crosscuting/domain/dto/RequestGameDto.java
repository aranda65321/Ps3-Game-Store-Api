package co.com.aranda.ps3.store.crosscuting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestGameDto {
    private long id;
    private String name;
    private Date creationDate;
    private String status;
}

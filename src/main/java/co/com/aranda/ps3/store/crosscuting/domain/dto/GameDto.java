package co.com.aranda.ps3.store.crosscuting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDto {

    private String name;
    private String language;
    private String size;
    private String type;
    private String region;
    private String numberId;
    private String servers;
    private String filePassword;
    private String description;
    private String trailerLink;
}

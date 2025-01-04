package pruebaTc.apiExterna.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NasaResponse {
      private String title;
    private String explanation;
    private String url;
    private String hdUrl;

    @JsonProperty("date")
    private String date;

    @JsonProperty("media_type")
    private String mediaType;
}

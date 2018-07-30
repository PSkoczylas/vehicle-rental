package pl.piotr.skoczylas.vehiclerental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Data
@Builder
@EqualsAndHashCode
public class VehicleDto {
    private Long id;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    private String vehicleType;

    //private Optional<LocalDate> borrowDate;
}

package pl.piotr.skoczylas.vehiclerental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleBorrowDto {
    private Long id;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    private String vehicleType;

    private Boolean isBorrowed;

    private BorrowDto borrow;
    private BorrowerDto borrower;
    private VehicleDto vehicle;

}

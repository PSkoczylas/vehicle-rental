package pl.piotr.skoczylas.vehiclerental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleWithBorrowDto {
    private Long id;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY)
    private String vehicleType;

    private boolean isBorrowed;

    private BorrowDto borrowDto;
    private VehicleDto vehicleDto;

}

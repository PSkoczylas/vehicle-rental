package pl.piotr.skoczylas.vehiclerental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowerDto {
    private String firstName;
    private String lastName;
}

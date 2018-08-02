package pl.piotr.skoczylas.vehiclerental.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowDto {
    private Long vehicleId;
    private LocalDate date;
    private Long borrowerId;
}

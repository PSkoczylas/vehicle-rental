package pl.piotr.skoczylas.vehiclerental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.piotr.skoczylas.vehiclerental.constant.Color;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
@ToString
public class EditCarDto {
    private String name;
    private Long id;
    private Color color;
    private LocalDate borrowDate;
}

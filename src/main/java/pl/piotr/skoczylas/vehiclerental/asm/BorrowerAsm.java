package pl.piotr.skoczylas.vehiclerental.asm;

import pl.piotr.skoczylas.vehiclerental.dto.BorrowerDto;
import pl.piotr.skoczylas.vehiclerental.model.Borrower;

public class BorrowerAsm {
    public static Borrower makeBorrower(BorrowerDto borrowerDto) {
        return Borrower.builder()
                .firstName(borrowerDto.getFirstName())
                .lastName(borrowerDto.getLastName())
                .build();
    }
}

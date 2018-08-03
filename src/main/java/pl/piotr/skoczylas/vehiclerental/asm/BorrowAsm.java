package pl.piotr.skoczylas.vehiclerental.asm;

import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.model.Borrow;

import java.util.stream.Collectors;
import java.util.List;

public class BorrowAsm {
    public static List<BorrowDto> getAllBorrowsDto(List<Borrow> borrows) {
        return borrows.stream()
                .map(BorrowAsm::getBorrowDto)
                .collect(Collectors.toList());
    }

    public static BorrowDto getBorrowDto(Borrow borrow) {
        return BorrowDto.builder()
                .vehicleId(borrow.getVehicle().getId())
                .date(borrow.getDate())
                .borrowerId(borrow.getBorrower().getId()).build();
    }

}

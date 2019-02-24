package pl.piotr.skoczylas.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piotr.skoczylas.vehiclerental.asm.BorrowAsm;
import pl.piotr.skoczylas.vehiclerental.asm.BorrowerAsm;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowerDto;
import pl.piotr.skoczylas.vehiclerental.exception.NotFoundException;
import pl.piotr.skoczylas.vehiclerental.model.Borrow;
import pl.piotr.skoczylas.vehiclerental.model.Borrower;
import pl.piotr.skoczylas.vehiclerental.model.Vehicle;
import pl.piotr.skoczylas.vehiclerental.repository.BorrowRepository;
import pl.piotr.skoczylas.vehiclerental.repository.BorrowerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    private final BorrowRepository borrowRepository;
    private final BorrowerRepository borrowerRepository;
    private final VehicleService vehicleService;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository, BorrowerRepository borrowerRepository, VehicleService vehicleService) {
        this.borrowRepository = borrowRepository;
        this.borrowerRepository = borrowerRepository;
        this.vehicleService = vehicleService;
    }

    public List<BorrowDto> getAllBorrows() {
        return this.getAllBorrowsDto(borrowRepository.findAll());
    }

    protected List<BorrowDto> getAllBorrowsDto(List<Borrow> borrows) {
        return BorrowAsm.getAllBorrowsDto(borrows);
    }

    public BorrowDto borrow(BorrowDto borrowDto) {
        Vehicle vehicle = vehicleService.getVehicleOrException(borrowDto.getVehicleId());
        Borrower borrower = getBorrowerOrException(borrowDto.getBorrowerId());
        Borrow borrow = Borrow.builder().borrower(borrower).vehicle(vehicle).date(borrowDto.getDate()).build();
        borrowRepository.save(borrow);
        return borrowDto;
    }

    public BorrowerDto addBorrower(BorrowerDto borrowerDto) {
        Borrower borrower = this.makeBorrower(borrowerDto);
        borrowerRepository.save(borrower);
        return borrowerDto;
    }

    protected Borrower makeBorrower(BorrowerDto borrowerDto) {
        return BorrowerAsm.makeBorrower(borrowerDto);
    }

    private Borrower getBorrowerOrException(Long id) {
        Optional<Borrower> borrower = borrowerRepository.findById(id);
        return borrower.orElseThrow(() -> new NotFoundException("Borrower with given ID doesn't exist"));
    }
}

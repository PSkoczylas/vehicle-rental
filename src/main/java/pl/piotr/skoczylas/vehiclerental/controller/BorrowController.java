package pl.piotr.skoczylas.vehiclerental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto;
import pl.piotr.skoczylas.vehiclerental.dto.BorrowerDto;
import pl.piotr.skoczylas.vehiclerental.service.BorrowService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/borrows")
@ResponseStatus(HttpStatus.OK)
public class BorrowController {
    @Autowired
    protected BorrowService borrowService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<BorrowDto> getBorrows() { return borrowService.getAllBorrows();}

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public BorrowDto add(@RequestBody BorrowDto borrowDto) {
        return borrowService.borrow(borrowDto);
    }

    @PostMapping("/addBorrower")
    @ResponseStatus(HttpStatus.OK)
    public BorrowerDto addBorrower(@RequestBody BorrowerDto borrowerDto) {
        return borrowService.addBorrower(borrowerDto);
    }
}

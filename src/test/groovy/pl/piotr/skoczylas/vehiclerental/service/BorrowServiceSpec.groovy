package pl.piotr.skoczylas.vehiclerental.service

import org.springframework.boot.test.context.SpringBootTest
import pl.piotr.skoczylas.vehiclerental.asm.BorrowAsm
import pl.piotr.skoczylas.vehiclerental.asm.BorrowerAsm
import pl.piotr.skoczylas.vehiclerental.dto.BorrowDto
import pl.piotr.skoczylas.vehiclerental.dto.BorrowerDto
import pl.piotr.skoczylas.vehiclerental.model.Borrow
import pl.piotr.skoczylas.vehiclerental.model.Borrower
import pl.piotr.skoczylas.vehiclerental.model.Vehicle
import pl.piotr.skoczylas.vehiclerental.repository.BorrowRepository
import pl.piotr.skoczylas.vehiclerental.repository.BorrowerRepository
import spock.lang.Specification

@SpringBootTest
class BorrowServiceSpec extends Specification {
    def borrowRepository = Mock(BorrowRepository)
    def borrowerRepository = Mock(BorrowerRepository)
    def vehicleService = Mock(VehicleService)
    def borrowDto1 = Mock(BorrowDto)
    def borrowDto2 = Mock(BorrowDto)
    def borrowDto3 = Mock(BorrowDto)
    def borrow1 = Mock(Borrow)
    def borrow3 = Mock(Borrow)
    def borrow2 = Mock(Borrow)
    def borrowAsm = Mock(BorrowAsm)
    def borrower = Mock(Borrower)
    def borrow = Mock(Borrow)
    def vehicle = Mock(Vehicle)
    def borrowerAsm = Mock(BorrowerAsm)
    def borrowerDto = Mock(BorrowerDto)

    def "create borrow service"() {
        when:
        def borrowService = new BorrowService(borrowRepository, borrowerRepository, vehicleService)
        then:
        borrowService != null
    }

    def "should return all borrow dto"() {
        given:
        def borrowList = Arrays.asList(borrow1, borrow2, borrow3)
        def borrowDtoList = Arrays.asList(borrowDto1, borrowDto2, borrowDto3)
        borrowRepository.findAll() >> borrowList
        def borrowService = Spy(BorrowService, constructorArgs: [borrowRepository, borrowerRepository, vehicleService]) {
            getAllBorrowsDto(borrowList) >> borrowDtoList
        }
        when:
        def b = borrowService.getAllBorrows()
        then:
        b == borrowDtoList
    }

    def "should borrow dto"() {
        given:
        def borrowService = new BorrowService(borrowRepository, borrowerRepository, vehicleService)
        vehicleService.getVehicleOrException(_) >> vehicle
        borrowerRepository.findById(_) >> Optional.of(borrower)
        borrowRepository.save(borrow) >> true
        when:
        def borrowDto = borrowService.borrow(borrowDto1)
        then:
        borrowDto == borrowDto1
    }

    def "should add borrower"() {
        given:
        def borrowService = Spy(BorrowService, constructorArgs: [borrowRepository, borrowerRepository, vehicleService]) {
            makeBorrower(borrowerDto) >> borrower
        }
        borrowerRepository.save(borrower) >> true
        when:
        BorrowerDto addedBorrowerDto = borrowService.addBorrower(borrowerDto)
        then:
        addedBorrowerDto == borrowerDto
    }

}

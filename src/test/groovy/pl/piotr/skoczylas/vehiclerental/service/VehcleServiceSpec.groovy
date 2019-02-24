package pl.piotr.skoczylas.vehiclerental.service

import pl.piotr.skoczylas.vehiclerental.asm.VehicleAsm
import pl.piotr.skoczylas.vehiclerental.dto.VehicleBorrowDto
import pl.piotr.skoczylas.vehiclerental.dto.VehicleDto
import pl.piotr.skoczylas.vehiclerental.model.Vehicle
import pl.piotr.skoczylas.vehiclerental.repository.BorrowRepository
import pl.piotr.skoczylas.vehiclerental.repository.VehicleRepository
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

class VehcleServiceSpec extends Specification {
    def vehicleRepository = Mock(VehicleRepository)
    def borrowRepository = Mock(BorrowRepository)
    def vehicle = Mock(Vehicle)
    PodamFactory factory = new PodamFactoryImpl()

    @Subject
    def vehicleService = new VehicleService(vehicleRepository, borrowRepository)

    def "should get vehicle"() {
        given:
        GroovyMock(VehicleAsm, global: true)
        VehicleAsm.getVehicleDto(_) >> Mock(VehicleDto)
        when:
        vehicleService.getVehicle(1)
        then:
        1 * vehicleRepository.findById(_) >> Optional.of(vehicle)
    }

    def "should get all vehicles"() {
        given:
        def vehicleDto1 = factory.manufacturePojo(VehicleDto.class)
        def vehicleDto2 = factory.manufacturePojo(VehicleDto.class)
        def vehicleDto3 = factory.manufacturePojo(VehicleDto.class)
        def vehicle1 = Mock(Vehicle)
        def vehicle2 = Mock(Vehicle)
        def vehicle3 = Mock(Vehicle)
        def vehicleDtoList = Arrays.asList(vehicleDto1, vehicleDto2, vehicleDto3)
        def vehicleList = Arrays.asList(vehicle1, vehicle2, vehicle3)
        vehicleRepository.findAll() >> vehicleList
        def vehicleServiceWithStub = Spy(VehicleService, constructorArgs: [vehicleRepository, borrowRepository]) {
            getAllVehiclesDto(vehicleList) >> vehicleDtoList
        }
        when:
        def b = vehicleServiceWithStub.getAllVehicles()
        then:
        b == vehicleDtoList
    }

    def "should remove vehicle"() {
        when:
        vehicleService.removeVehicle(1)
        then:
        1 * vehicleRepository.findById(_) >> Optional.of(vehicle)
        1 * vehicleRepository.delete(_)
    }

    def "should get vehicle for given day"() {
        given:
        def vehicle1 = Mock(Vehicle)
        def vehicle2 = Mock(Vehicle)
        def vehicleList = Arrays.asList(vehicle1, vehicle2)
        def vehicleBorrowDto = Mock(VehicleBorrowDto)
        def vehicleServiceWithStub = Spy(VehicleService, constructorArgs: [vehicleRepository, borrowRepository]) {
            makeVehicleBorrowDto(_) >> VehicleBorrowDto
        }
        when:
        def vehicleForGivenDay = vehicleServiceWithStub
                .getVehicleWithBorrowForGivenDay(LocalDate.of(2015, 10, 12))
        then:
        vehicleRepository.findAll() >> vehicleList
        vehicleForGivenDay.size() == 2
    }
}

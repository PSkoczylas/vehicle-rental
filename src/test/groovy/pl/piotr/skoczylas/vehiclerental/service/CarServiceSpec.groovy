package pl.piotr.skoczylas.vehiclerental.service

import org.springframework.boot.test.context.SpringBootTest
import pl.piotr.skoczylas.vehiclerental.asm.CarAsm
import pl.piotr.skoczylas.vehiclerental.dto.CarDto
import pl.piotr.skoczylas.vehiclerental.dto.EditCarDto
import pl.piotr.skoczylas.vehiclerental.model.Car
import pl.piotr.skoczylas.vehiclerental.model.Manufacturer
import pl.piotr.skoczylas.vehiclerental.repository.CarRepository
import pl.piotr.skoczylas.vehiclerental.repository.ManufacturerRepository
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class CarServiceSpec extends Specification {
    def carRepository = Mock(CarRepository)
    def manufacturerRepository = Mock(ManufacturerRepository)
    def carDto = Mock(CarDto)
    def car = Mock(Car)
    def manufacturer = Mock(Manufacturer)
    PodamFactory factory = new PodamFactoryImpl()

    @Subject
    def carService = new CarService(carRepository, manufacturerRepository)

    def "should make car"() {
        given:
        carDto = factory.manufacturePojo(carDto.class)
        GroovyMock(CarAsm, global: true)
        CarAsm.makeCar(_) >> car
        GroovyMock(Manufacturer, global: true)
        Manufacturer.builder() >> manufacturer
        manufacturerRepository.save(_) >> true
        when:
        carService.add(carDto)
        then:
        1 * carRepository.save(_)
        1 * manufacturerRepository.findByName(carDto.getName()) >> null
        1 * manufacturerRepository.save(_)
    }

    def "should edit car"() {
        given:
        def editCarDto = factory.manufacturePojo(EditCarDto.class)
        def optionalCar = Optional.of(car)

        when:
        carService.editCar(1, editCarDto)

        then:
        1 * carRepository.findById(1) >> optionalCar
    }
}

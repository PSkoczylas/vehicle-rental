package pl.piotr.skoczylas.vehiclerental.service

import org.springframework.boot.test.context.SpringBootTest
import pl.piotr.skoczylas.vehiclerental.model.Bike
import pl.piotr.skoczylas.vehiclerental.repository.BikeRepository
import spock.lang.Specification

@SpringBootTest
class BikeServiceSpec extends Specification {
    def bikeRepository = Mock(BikeRepository)
    def bike = Mock(Bike)

    def "should create bike service"() {
        when:
            def bikeService = new BikeService(bikeRepository)
        then:
            bikeService != null
    }

    def "should return bike by number when exist"() {
        given:
        bike.getId() >> 1
        bikeRepository.getOne(1) >> bike
        bikeRepository.getByNumber(1) >> bike
        when:
        def bikeService = new BikeService(bikeRepository)
        then:
        bikeService.createNumber(1) == bike
    }

    def "should create and return bike by number when no exist"() {
        given:
        bike.getId() >> 1
        bikeRepository.save(new Bike(1)) >> bike
        when:
        def bikeService = new BikeService(bikeRepository)
        then:
        bikeService.createNumber(1) == bike
    }
}

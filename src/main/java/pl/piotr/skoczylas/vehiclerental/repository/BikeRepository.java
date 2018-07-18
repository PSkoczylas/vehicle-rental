package pl.piotr.skoczylas.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piotr.skoczylas.vehiclerental.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
}

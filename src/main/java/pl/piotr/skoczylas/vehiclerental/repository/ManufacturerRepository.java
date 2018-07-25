package pl.piotr.skoczylas.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.piotr.skoczylas.vehiclerental.model.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    public Manufacturer findByName(String name);
}

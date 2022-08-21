package seniortest.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seniortest.apirest.entity.Item;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById(UUID id);
    void deleteById(UUID id);

}

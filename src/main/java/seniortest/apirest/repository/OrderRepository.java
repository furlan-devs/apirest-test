package seniortest.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seniortest.apirest.entity.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(UUID id);

    void deleteById(UUID id);
}

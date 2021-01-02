package ir.ssatari.envers.dal.repository;

import ir.ssatari.envers.dal.entity.CustomerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	Optional<CustomerEntity> findByFirstNameAndLastName(String firstName, String lastName);
}

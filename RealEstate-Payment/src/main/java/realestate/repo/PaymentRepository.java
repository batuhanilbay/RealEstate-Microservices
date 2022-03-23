package realestate.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import realestate.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository< Payment, Long > {

	@Query(value = "select * from realestate.payments where userId = :value",nativeQuery = true)
	Optional<Payment> getPaymentsByUserId(@Param("value") Long value);

	
}

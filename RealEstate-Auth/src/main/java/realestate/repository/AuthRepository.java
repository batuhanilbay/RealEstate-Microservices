package realestate.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import realestate.entity.User;


public interface AuthRepository extends JpaRepository<User, Long>{
	
	//@Query(value = "select * from realestate.users where email = :value",nativeQuery = true)

	User findByEmail(String email);

}

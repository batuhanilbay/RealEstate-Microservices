package realestate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import realestate.model.concretes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


	
}

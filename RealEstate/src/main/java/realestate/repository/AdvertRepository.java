package realestate.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import realestate.model.concretes.Advert;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {

	
	//Query control by userId
	
	@Query(value = "select * from realestate.adverts where userId = :value",nativeQuery = true)
	Collection<Advert> getAdvertsByUserId(@Param("value") Long value);
	

}

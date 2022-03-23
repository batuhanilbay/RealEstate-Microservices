package realestate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import realestate.model.concretes.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	
	//Query control by userId
	@Query(value = "select * from realestate.products where userId = :value",nativeQuery = true)
	Product getProductsByUserId(@Param("value") Long value);
	
}

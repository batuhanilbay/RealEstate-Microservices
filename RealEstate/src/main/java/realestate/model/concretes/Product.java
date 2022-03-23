package realestate.model.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.abstracts.BaseEntity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="Product")
@Table(name = "Products")
public class Product implements BaseEntity{

	//Ürünü (Yayınlama hakkı) satın almak için oluşturulan sınıf.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	private Long id;
	private Date  buyDate;
	private Date  expiredDate;
	private int dayOfCounter;
	private int numberOfQuantityAdvert;
	private Long userId;
	






}

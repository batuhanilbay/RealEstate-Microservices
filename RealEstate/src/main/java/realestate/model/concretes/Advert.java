package realestate.model.concretes;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.abstracts.BaseEntity;
import realestate.model.enums.HouseType;
import realestate.model.enums.PropertyType;
import realestate.model.enums.StatusType;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="Advert")
@Table(name = "Adverts")

public class Advert implements BaseEntity{

	/*
	 * İlan için gerekli özellikler, burada Enum sınıflar kullanılmıştır.
	 *
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advert_id", unique = true, nullable = false)
	private Long id;
	private String title;
	private String content;
    @JsonFormat(pattern="dd-MM-yyyy")
	private Date createDate;
	private Long price;
	@Enumerated(EnumType.STRING)
	private HouseType houseType;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	//IN-REVIEW
	@Enumerated(EnumType.STRING)
	private StatusType statusType;
	private Long userId;

	
	

}

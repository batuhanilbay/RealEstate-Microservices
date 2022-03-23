package realestate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import realestate.model.enums.TransferType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
@Entity(name="Payments")
@Table(name = "Payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", unique = true, nullable = false)
	private Long id;
	private Long userId;
	private Boolean isPaid;
	@Enumerated(EnumType.STRING)
	private TransferType transferType;
	//private UserDetail user;
	
	
	

}

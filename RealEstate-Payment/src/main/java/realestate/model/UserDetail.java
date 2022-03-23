package realestate.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDetail {
	
	private Long id;
	private String userName;
	private String mail;
	//private Set<Payment> payments = new HashSet<>();
	
	

}

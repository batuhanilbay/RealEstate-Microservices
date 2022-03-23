package realestate.model.concretes;


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
import realestate.model.abstracts.BaseEntity;
import realestate.model.enums.UserType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name= "User")
@Table(name = "Users")

public class User implements BaseEntity{

	//Kullanıcıya ait özellikleri barındıran model sınıfı...

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Long id;
	private String username;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserType userType;





}




/*
 * //Kullanıcının birden fazla ilanı olabilir.
	@OneToMany(mappedBy = "creatorUser",cascade = CascadeType.ALL)
	private Set<Advert> activeAdverts = new HashSet<>();

	@OneToMany(mappedBy = "creatorUser",cascade = CascadeType.ALL)
	private Set<Advert> passiveAdverts = new HashSet<>();
 *
 *
 */

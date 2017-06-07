import java.io.Serializable;
import java.util.Calendar;



public class User extends Person implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variables
	String username;
	String password; 
	String email;
	String phoneNumber;
	String profilephoto; 
//Constructors
	User(){};
	User(String username){this.username = username;}
	User(String username, String password ){this.username = username; this.password = password;}
	User(String username, String password, String email ){this.username = username; this.password = password; this.email = email;}
	User(String username, String password, String email, String phoneNumber ){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber;}
	User(String username, String password, String email, String phoneNumber, String profilephoto){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto;}
	User(String username, String password, String email, String phoneNumber, String profilephoto, String firstname){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto; 
		setFirstname(firstname);}
	User(String username, String password, String email, String phoneNumber, String profilephoto, String firstname, String lastname){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto; 
	setFirstname(firstname); setLastname(lastname);}
	User(String username, String password, String email, String phoneNumber, String profilephoto, String firstname, String lastname, String ssn){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto; 
	setFirstname(firstname); setLastname(lastname); setSSN(ssn);}
	User(String username, String password, String email, String phoneNumber, String profilephoto, String firstname, String lastname, String ssn, String gender){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto; 
	setFirstname(firstname); setLastname(lastname); setSSN(ssn); setGender(gender);}
	User(String username, String password, String email, String phoneNumber, String profilephoto, String firstname, String lastname, String ssn, String gender, Calendar dob){this.username = username; this.password = password; this.email = email; this.phoneNumber = phoneNumber; this.profilephoto = profilephoto; 
	setFirstname(firstname); setLastname(lastname); setSSN(ssn); setGender(gender); setDOB(dob);}
//Mutator / Accessor Methods  --obviously we're gonna have to lock down a couple of these methods later on...
	public void setUsername(String username){this.username = username;}
	public String getUsername(){return this.username;}
	public void setPassword(String password){this.password = password;}
	public String getPassword(){return this.password;}
	public void setEmail(String email){this.email = email;}
	public String getEmail(){return this.email;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
	public String getPhoneNumber(){return this.phoneNumber;}
	public void setString(String profilephoto){this.profilephoto = profilephoto;}
	public String getString(){return this.profilephoto;}

}

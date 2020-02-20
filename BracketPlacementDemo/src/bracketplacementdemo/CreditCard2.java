package bracketplacementdemo;
import java.util.ArrayList;

public class CreditCard2
{
	private String name;
	private String type;
	private String number;
	private Integer expirationMonth;
	private Integer expirationYear;
	private String cvc;
	
	private ArrayList<String> authorizedUsers = new ArrayList<>();
	
	public void addAuthorizedUser(String userName) {
		authorizedUsers.add(userName);
	}
	
	public void printInfoWithoutPersonalData() {
		System.out.println("Card details:");
		System.out.println("");
		System.out.println("  Cardholder name: " + obscureName(name));
		System.out.println("  Type: " + type);
		System.out.println("  Card number: " + obscureNumber());
		System.out.println("  Expires: " + expirationMonth + "/" + expirationYear);
		System.out.println("  CVC: XX" + cvc.substring(2));
		System.out.println("  Authorized users:");
		authorizedUsers.forEach(user -> {
			if (user == "Secret Agent Man") {
				System.out.println("    Forbidden info");
			}
			else {
				System.out.println("    " + obscureName(user));
			}
		});
	}
	
	private String obscureName(String name) {
		String initial = name.substring(0, 1);
		String obscuredInfo = "*".repeat(name.length() - 1);
		return initial + obscuredInfo;
	}
	
	private String obscureNumber() {
		String obscuredInfo = "XXXX-XXXX-XXXX-";
		String last4 = number.substring(12);
		return obscuredInfo + last4;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(String type) {
		if (type == "American Express") {
			throw new IllegalArgumentException("American Express is not supported");
		}
		
		this.type = type;
	}
	
	public void setNumber(String number) {		
		if (number.length() != 16) {
			throw new IllegalArgumentException("Card number must be 16 digits long");
		}
		
		this.number = number;
	}
	
	public void setExpirationMonth(Integer expirationMonth) {
		if (expirationMonth < 0 || expirationMonth > 12) {
			throw new IllegalArgumentException("Invalid month specified");
		}
		
		this.expirationMonth = expirationMonth;
	}
	
	public void setExpirationYear(Integer expirationYear) {
		if (expirationYear < 1970) {
			throw new IllegalArgumentException("Invalid year specified");
		}
		
		this.expirationYear = expirationYear;
	}
	
	public void setCVC(String cvc) {
		if (cvc.length() != 3) {
			throw new IllegalArgumentException("CVC must be 3 digits long");
		}
		
		this.cvc = cvc;
	}
	
}

package med.voll.api.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    public Address(AddressRegisterPayload req) {
    	this.street = req.street();
        this.number = req.number();
        this.complement = req.complement();
        this.district = req.district();
        this.city = req.city();
        this.state = req.state();
        this.zipCode = req.zipCode();
	}

	public void update(AddressRegisterPayload req) {
		if (req.street() != null) {
			this.street = req.street();
		}
		
		if (req.number() != null) {
			this.number = req.number();
		}
		
		if (req.complement() != null) {
			this.complement = req.complement();
		}
		
		if (req.district() != null) {
			this.district = req.district();
		}
		
		if (req.city() != null) {
			this.city = req.city();
		}
		
		if (req.state() != null) {
			this.state = req.state();
		}
		
		if (req.zipCode() != null) {
			this.zipCode = req.zipCode();
		}
		
	}
}

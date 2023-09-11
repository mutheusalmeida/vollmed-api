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
    
    public Address(AddressRegisterPayload address) {
    	this.street = address.street();
        this.number = address.number();
        this.complement = address.complement();
        this.district = address.district();
        this.city = address.city();
        this.state = address.state();
        this.zipCode = address.zipCode();
	}
}

package med.voll.api.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    
    @Column(name = "zip_code")
    private String zipCode;
}

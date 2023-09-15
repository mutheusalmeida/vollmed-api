package med.voll.api.domain.address;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressUpdateRequestPayload(
		
		@Size(min = 1, message = "Street cannot be blank")
		String street,
		
	    String number,
	    String complement,
	    
	    @Size(min = 1, message = "District cannot be blank")
	    String district,
	    
	    @Size(min = 1, message = "City cannot be blank")
	    String city,
	    
	    @Size(min = 1, message = "State cannot be blank")
	    String state,
	    
	    @Size(min = 1, message = "Zip code cannot be blank")
	    @Pattern(regexp = "\\d{8}", message = "Invalid zip code")
	    String zipCode
		) {

}

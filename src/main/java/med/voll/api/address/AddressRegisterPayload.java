package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRegisterPayload(
		
		@NotBlank
		String street,
		
	    String number,
	    String complement,
	    
	    @NotBlank
	    String district,
	    
	    @NotBlank
	    String city,
	    
	    @NotBlank
	    String state,
	    
	    @NotBlank
	    @Pattern(regexp = "\\d{8}")
	    String zipCode
		) {

}

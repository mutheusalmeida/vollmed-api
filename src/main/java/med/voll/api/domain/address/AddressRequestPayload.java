package med.voll.api.domain.address;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressRequestPayload(
		
		@Size(min = 1, message = "Street cannot be blank")
		@NotNull(message = "Street is required")
		String street,
		
	    String number,
	    String complement,
	    
	    @Size(min = 1, message = "District cannot be blank")		@NotNull(message = "District is required")
	    String district,
	    
	    @Size(min = 1, message = "City cannot be blank")		@NotNull(message = "City is required")
	    String city,
	    
	    @Size(min = 1, message = "State cannot be blank")		@NotNull(message = "State is required")
	    String state,
	    
	    @Size(min = 1, message = "Zip code cannot be blank")		@NotNull(message = "Zip code is required")
	    @Pattern(regexp = "\\d{8}", message = "Invalid zip code")
	    String zipCode
		) {

}

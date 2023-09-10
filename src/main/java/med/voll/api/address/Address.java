package med.voll.api.address;

public record Address(
		String street,
	    String number,
	    String complement,
	    String district,
	    String city,
	    String state,
	    String zipCode
		) {

}

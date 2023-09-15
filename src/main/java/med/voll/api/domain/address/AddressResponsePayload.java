package med.voll.api.domain.address;

public record AddressResponsePayload(
		String street,
	    String number,
	    String complement,
	    String district,
	    String city,
	    String state,
	    String zipCode
		) {
	public AddressResponsePayload(Address address) {
		this(
				address.getStreet(), 
				address.getNumber(), 
				address.getComplement(), 
				address.getDistrict(), 
				address.getCity(), 
				address.getState(), 
				address.getZipCode()
				);
	}
}

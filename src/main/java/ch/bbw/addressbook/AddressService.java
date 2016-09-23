package ch.bbw.addressbook;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AddressService {
	
	@Inject
	private AddressDAO_Memory addressDAO;
	
	public AddressService() {
	}
	
	public List<Address> getAllAddresses() {
		// TODO: Order by lastname
		return addressDAO.readAll();
	}
	
	public void storeAddress(Address address) {
		addressDAO.create(address);
	}

}

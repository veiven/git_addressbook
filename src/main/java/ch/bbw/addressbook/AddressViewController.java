package ch.bbw.addressbook;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddressViewController {
	
	@Inject
	private AddressService addressService;
	
    private String firstname;
    private String lastname;
    private String number;

    public void saveAddress() {
        Address address = new Address(0, firstname, lastname, number);
        addressService.storeAddress(address);
    }
    public List<Address> getAddresses() {
        return addressService.getAllAddresses();
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}

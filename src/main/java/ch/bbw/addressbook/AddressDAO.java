package ch.bbw.addressbook;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AddressDAO {
	
	private Connection connection; // TODO: to be replaced by connection pool
	
	public AddressDAO() {
	}
	
	@PostConstruct
	private void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/AddressBook","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	@PreDestroy
	private void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// CRUD Commands: Create Read Update Delete
	public void create(Address address) {
		// TODO: create, not implemented yet
	}
	
	public Address read(int id) {
		// TODO: read, not implemented yet
		return null;
	}
	
	public List<Address> readAll() {
		List<Address> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet entries = stmt.executeQuery("SELECT * FROM address");
			while (entries.next()) {
				list.add(new Address(
						entries.getInt("id"), entries.getString("firstname"), 
						entries.getString("lastname"), entries.getString("phonenumber")));
			}
			entries.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void update(Address address) {
		// TODO: update, not implemented yet
	}
	
	public void delete(int id) {
		// TODO: delete, not implemented yet
	}

}

package com.assignment.Assignment.Project.model;

 
import jakarta.persistence.*;

@Entity
@Table(name = "Contact_Mech")
public class ContactMech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contact_mech_id;
    
    private Integer customer_id; // Simple mapping for foreign key
    private String street_address;
    private String city;
    private String state;
    private String postal_code;
    private String phone_number;
    private String email;
	public Integer getContact_mech_id() {
		return contact_mech_id;
	}
	public void setContact_mech_id(Integer contact_mech_id) {
		this.contact_mech_id = contact_mech_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    
    
    
 }

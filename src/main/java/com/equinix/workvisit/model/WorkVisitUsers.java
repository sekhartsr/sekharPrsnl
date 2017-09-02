package com.equinix.workvisit.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORK_VISIT_USERS")
public class WorkVisitUsers extends AbstractEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="COMPANY")
	private String company;

	public WorkVisitUsers() {
	}

	public WorkVisitUsers(String userName, String firstName, String lastName, String company) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String getCreateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateId(String createId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Timestamp getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateDt(Timestamp createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUpdateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdateId(String updateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Timestamp getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdateDt(Timestamp updateDt) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
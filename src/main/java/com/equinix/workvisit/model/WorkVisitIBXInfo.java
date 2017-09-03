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
@Table(name="WORK_VISIT_IBX_INFO")
public class WorkVisitIBXInfo extends AbstractEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IBX_ID")
	private int id;
	
	@Column(name="IBX")
	private String ibx;
	
	@Column(name="CAGE")
	private String cage;
	
	@Column(name="CABINET")
	private String cabinet;

	public WorkVisitIBXInfo() {
	}

	public WorkVisitIBXInfo(String ibx, String cage, String cabinet) {
		this.ibx = ibx;
		this.cage = cage;
		this.cabinet = cabinet;
	}

	/**
	 * @return the ibx
	 */
	public String getIbx() {
		return ibx;
	}

	/**
	 * @param ibx the ibx to set
	 */
	public void setIbx(String ibx) {
		this.ibx = ibx;
	}

	/**
	 * @return the cage
	 */
	public String getCage() {
		return cage;
	}

	/**
	 * @param cage the cage to set
	 */
	public void setCage(String cage) {
		this.cage = cage;
	}

	/**
	 * @return the cabinet
	 */
	public String getCabinet() {
		return cabinet;
	}

	/**
	 * @param cabinet the cabinet to set
	 */
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
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
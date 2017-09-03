package com.equinix.workvisit.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "WORK_VISIT")
public class WorkVisit extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WV_ID")
	private int id;

	@Column(name = "WV_IBX")
	private String ibx;

	@Column(name = "WV_CAGE")
	private String cage;

	@Column(name = "WV_CABINET")
	private String cabinet;
	
	@Column(name = "WV_USEER")
	private String workVisitUser;
	
	@Column(name = "WV_DTLS")
	private String workVisitDtls;

	@Transient
	private List<WorkVisitUsers> workVisitUsers;
	
	@Transient
	private List<WorkVisitDetails> workVisitDetails;

	public WorkVisit() {
	}

	public WorkVisit(String ibx, String cage, String cabinet, List<WorkVisitUsers> workVisitUsers) {
		this.ibx = ibx;
		this.cage = cage;
		this.cabinet = cabinet;
		this.workVisitUsers = workVisitUsers;
		// this.workVisitDetails = workVisitDetails;
	}

	/**
	 * @return the ibx
	 */
	public String getIbx() {
		return ibx;
	}

	/**
	 * @param ibx
	 *            the ibx to set
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
	 * @param cage
	 *            the cage to set
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
	 * @param cabinet
	 *            the cabinet to set
	 */
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

	/**
	 * @return the workVisitUsers
	 */
	public List<WorkVisitUsers> getWorkVisitUsers() {
		return workVisitUsers;
	}

	/**
	 * @param workVisitUsers
	 *            the workVisitUsers to set
	 */
	public void setWorkVisitUsers(List<WorkVisitUsers> workVisitUsers) {
		this.workVisitUsers = workVisitUsers;
	}
	
	/**
	 * @return the workVisitUser
	 */
	public String getWorkVisitUser() {
		return workVisitUser;
	}

	/**
	 * @param workVisitUser the workVisitUser to set
	 */
	public void setWorkVisitUser(String workVisitUser) {
		this.workVisitUser = workVisitUser;
	}

	/**
	 * @return the workVisitDtls
	 */
	public String getWorkVisitDtls() {
		return workVisitDtls;
	}

	/**
	 * @param workVisitDtls the workVisitDtls to set
	 */
	public void setWorkVisitDtls(String workVisitDtls) {
		this.workVisitDtls = workVisitDtls;
	}

	/**
	 * @return the workVisitDetails
	 */
	public List<WorkVisitDetails> getWorkVisitDetails() {
		return workVisitDetails;
	}

	/**
	 * @param workVisitDetails the workVisitDetails to set
	 */
	public void setWorkVisitDetails(List<WorkVisitDetails> workVisitDetails) {
		this.workVisitDetails = workVisitDetails;
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
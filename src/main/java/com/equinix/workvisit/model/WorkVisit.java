package com.equinix.workvisit.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "WORK_VISIT")
public class WorkVisit implements Serializable{

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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "WV_DTLS_START_DT")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "WV_DTLS_END_DT")
	private Date endDate;
	
	@Column(name = "WV_DTLS_START_TM")
	private String startTime;
	
	@Column(name = "WV_DTLS_END_TM")
	private String endTime;
	
	@Column(name = "CREATE_DATE")
	private Timestamp createDt;

	@Transient
	private List<WorkVisitUsers> workVisitUsers;
	
	public WorkVisit() {
	}

	public WorkVisit(String ibx, String cage, String cabinet, List<WorkVisitUsers> workVisitUsers, Date startDate, Date endDate, String startTime,  String endTime) {
		this.ibx = ibx;
		this.cage = cage;
		this.cabinet = cabinet;
		this.workVisitUsers = workVisitUsers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the createDt
	 */
	public Timestamp getCreateDt() {
		return createDt;
	}

	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}

	
}
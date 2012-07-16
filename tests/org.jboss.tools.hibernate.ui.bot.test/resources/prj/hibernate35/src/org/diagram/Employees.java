package org.diagram;

// Generated Jul 16, 2012 4:06:14 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Employees generated by hbm2java
 */
public class Employees implements java.io.Serializable {

	private int employeenumber;
	private String email;
	private String extension;
	private String firstname;
	private String jobtitle;
	private String lastname;
	private String officecode;
	private Integer reportsto;
	private Set customerses = new HashSet(0);

	public Employees() {
	}

	public Employees(int employeenumber, String email, String extension,
			String firstname, String jobtitle, String lastname,
			String officecode) {
		this.employeenumber = employeenumber;
		this.email = email;
		this.extension = extension;
		this.firstname = firstname;
		this.jobtitle = jobtitle;
		this.lastname = lastname;
		this.officecode = officecode;
	}

	public Employees(int employeenumber, String email, String extension,
			String firstname, String jobtitle, String lastname,
			String officecode, Integer reportsto, Set customerses) {
		this.employeenumber = employeenumber;
		this.email = email;
		this.extension = extension;
		this.firstname = firstname;
		this.jobtitle = jobtitle;
		this.lastname = lastname;
		this.officecode = officecode;
		this.reportsto = reportsto;
		this.customerses = customerses;
	}

	public int getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(int employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getOfficecode() {
		return this.officecode;
	}

	public void setOfficecode(String officecode) {
		this.officecode = officecode;
	}

	public Integer getReportsto() {
		return this.reportsto;
	}

	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}

	public Set getCustomerses() {
		return this.customerses;
	}

	public void setCustomerses(Set customerses) {
		this.customerses = customerses;
	}

}

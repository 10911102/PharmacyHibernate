package com.medical.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.medical.pojo.Doctor;


public class DoctorDAO  implements IDoctorDAO{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public List<Doctor> getAll() throws SQLException {
		 return this.hibernateTemplate.loadAll(Doctor.class);
	}


	/*
	 * public List<Doctor> searchName(String name) { String query =
	 * "select * from doctor where fname like '%"+name+"%' or lname like '%"+name+
	 * "%'"; List<Doctor> doctors = hibernateTemplate.query(query, new
	 * DoctorMapper()); return doctors; }
	 */

	public List<Doctor> searchByFName(String name) {
		Doctor doctor=new Doctor();
		doctor.setfName(name);
		return hibernateTemplate.findByExample(doctor);
	}


	public List<Doctor> searchByLName(String name) {
		Doctor doctor=new Doctor();
		doctor.setlName(name);
		return hibernateTemplate.findByExample(doctor);
	}


	

}

package com.medical.dao;

import java.sql.SQLException;
import java.util.List;

import com.medical.pojo.Doctor;

public interface IDoctorDAO {
	public int insert(Doctor doctor);
	public List<Doctor> getAll()throws SQLException;
	public List<Doctor> searchByFName(String name);
	public List<Doctor> searchByLName(String name);

}

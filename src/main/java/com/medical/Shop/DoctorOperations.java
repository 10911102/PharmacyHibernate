package com.medical.Shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.medical.dao.IDoctorDAO;
import com.medical.dao.IPrescriptionDAO;
import com.medical.pojo.Doctor;
import com.medical.pojo.Prescription;

public class DoctorOperations {
	private IDoctorDAO doctorDAO;
	private IPrescriptionDAO prescriptionDAO;
	private ShopOperations shop;

	public IDoctorDAO getDoctorDAO() {
		return doctorDAO;
	}
	public void setDoctorDAO(IDoctorDAO doctorDAO) {
		this.doctorDAO = doctorDAO;
	}
	
	public ShopOperations getShop() {
		return shop;
	}
	public void setShop(ShopOperations shop) {
		this.shop = shop;
	}
	
	
	public IPrescriptionDAO getPrescriptionDAO() {
		return prescriptionDAO;
	}
	public void setPrescriptionDAO(IPrescriptionDAO prescriptionDAO) {
		this.prescriptionDAO = prescriptionDAO;
	}
	/**
	 * Search name of doctor from list. may be first name or last name of the doctor.
	 * @param name The String to search in Doctor List
	 * @return doctor object if it is present in list, if not then return null
	 * @throws SQLException 
	 */
	public List<Doctor> searchDoctor(String name) throws SQLException{
		List<Doctor> list=doctorDAO.getAll();
		List<Doctor> doctors=new ArrayList<Doctor>();
		for(Doctor doctor: list) {
			if(doctor.getfName().equalsIgnoreCase(name)|| doctor.getlName().equalsIgnoreCase(name))
				doctors.add(doctor);
		}
		
		return doctors;
	}
	/**
	 * Prints the list of doctors present in system.
	 * @throws SQLException
	 */
	public void showAllDoctors() throws SQLException {
		System.out.println("Doctor_Id        First_name       Last_name ");
		for (Doctor doctor : doctorDAO.getAll()) {
			System.out.println(doctor.getId()+"   "+doctor.getfName()+"    "+doctor.getlName());
		}
	}
	public void insert(Doctor doctor) {
		doctorDAO.insert(doctor);
	}
	public List<Prescription> create() {
		try {
			showAllDoctors();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		System.out.println("Enter Doctor Id");
		int doctorId=shop.sc.nextInt();
		shop.sc.nextLine();
		List<Prescription> finalPrescription=new ArrayList<Prescription>();
		int choice=0;
		do {
		shop.showAllMedicine();
		Prescription prescription=new Prescription();
		System.out.println("Enter Medicine_Id to sell medicine");
		int id = shop.sc.nextInt();
		shop.sc.nextLine();
		prescription.setMedicine_id(id);
		System.out.println("Enter quantity");
		int quantity = shop.sc.nextInt();
		shop.sc.nextLine();
		prescription.setQuantity(quantity);
		prescription.setDoctor_id(doctorId);
		finalPrescription.add(prescription);
		prescriptionDAO.insert(prescription);
		System.out.println("Press 1 to add more or o for exit");
		choice=shop.sc.nextInt();
		shop.sc.nextLine();
		}while(choice!=0);
		return finalPrescription;
	}

}

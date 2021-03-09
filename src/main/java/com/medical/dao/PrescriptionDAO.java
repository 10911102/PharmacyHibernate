package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.medical.pojo.Prescription;

public class PrescriptionDAO implements IPrescriptionDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void insert(Prescription prescription) {
		hibernateTemplate.update(prescription);
	}

	public List<Prescription> getAll() {
		return hibernateTemplate.loadAll(Prescription.class);
	}

	public Prescription getById(int medicineId) {
		Prescription prescription = new Prescription();
		prescription.setMedicine_id(medicineId);
		/*
		 * String query = "select * from pharmacy where Medicine_id =?";
		 * RowMapper<PharmacyStock> rowMapper = new PharmacyMapper();
		 */
		List<Prescription> list = hibernateTemplate.findByExample(prescription);
		return list.get(0);
	}

	public void update(Prescription prescription) {
		// String query = "update Pharmacy set Qauntity = "+quantity+" where id
		// ="+pharmacy.getId()+" ";
		hibernateTemplate.update(prescription);
	}

}

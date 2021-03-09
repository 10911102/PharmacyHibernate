package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.medical.pojo.PharmacyStock;

public class PharmacyStockDAO implements IPharmacyStockDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insert(PharmacyStock pharmacyStock) {
		 hibernateTemplate.update(pharmacyStock);
	}

	public List<PharmacyStock> getAll() {
		return hibernateTemplate.loadAll(PharmacyStock.class);
	}

	public PharmacyStock getById(int medicineId) {
		PharmacyStock pharmacyStock=new PharmacyStock();
		pharmacyStock.setMedicineId(medicineId);
		/*
		 * String query = "select * from pharmacy where Medicine_id =?";
		 * RowMapper<PharmacyStock> rowMapper = new PharmacyMapper();
		 */
		List<PharmacyStock> list=hibernateTemplate.findByExample(pharmacyStock);
		return list.get(0);
	}
	public void update(PharmacyStock pharmacy) {
		//String query = "update Pharmacy set Qauntity = "+quantity+" where id ="+pharmacy.getId()+" ";
		 hibernateTemplate.update(pharmacy);
	}

}

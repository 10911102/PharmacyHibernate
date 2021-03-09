package com.medical.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.medical.pojo.Medicine;

public class MedicineDAO implements IMedicineDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Medicine medicine) {
		Integer modifiedColoums = (Integer) hibernateTemplate.save(medicine);
		return modifiedColoums;
	}

	public List<Medicine> getAll() {
		List<Medicine> list = hibernateTemplate.loadAll(Medicine.class);
		return list;
	}

	/*
	 * public List<Medicine> searchMedicine(String name) { //String query =
	 * "select * from medicine where name like '%" + name + "%' or brand like '%" +
	 * name + "%'"; Medicine medicine=new Medicine(); medicine.setName(name);
	 * List<Medicine> list = hibernateTemplate.findByExample(medicine); return list;
	 * }
	 */
	public Medicine getById(int medicineId) {
		/*
		 * String query = "select * from medicine where id=?"; RowMapper<Medicine>
		 * rowMapper = new MedicineMapper();
		 */
		Medicine medicine=new Medicine();
		medicine.setId(medicineId);
		List<Medicine> medicines=  hibernateTemplate.findByExample(medicine);
		return medicines.get(0);
	}
	public List<Medicine> getByName(String name) {
		Medicine medicine=new Medicine();
		medicine.setName(name);
		List<Medicine> list =  hibernateTemplate.findByExample(medicine);
		return list;
	}
	public List<Medicine> getByBrand(String brand) {
		Medicine medicine=new Medicine();
		medicine.setBrand(brand);
		List<Medicine> list =  hibernateTemplate.findByExample(medicine);
		return list;
	}

}

package com.medical.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.pojo.PharmacyStock;

public class PharmacyMapper implements RowMapper<PharmacyStock> {

	public PharmacyStock mapRow(ResultSet rs, int rowNum) throws SQLException {
		PharmacyStock pharmacy=new PharmacyStock();
		pharmacy.setId(rs.getInt(1));
		pharmacy.setMedicineId(rs.getInt(2));
		pharmacy.setQuantity(rs.getInt(3));
		return pharmacy;
	}

}

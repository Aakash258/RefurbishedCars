package com.refurbished.cars.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.refurbished.cars.models.SellerDetailsModel;

public class SellerDetailsRowMapper implements RowMapper<SellerDetailsModel> {

	@Override
	public SellerDetailsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SellerDetailsModel seller = new SellerDetailsModel();
		seller.setSeller_id(rs.getInt("seller_id"));
		seller.setSeller_id(rs.getInt("pincode"));
		seller.setSeller_id(rs.getInt("phone"));
		seller.setAddress(rs.getString("address"));
		seller.setAddress(rs.getString("company_logo"));
		seller.setAddress(rs.getString("company_name"));
		seller.setAddress(rs.getString("email"));
		seller.setAddress(rs.getString("city"));
		seller.setAddress(rs.getString("state"));
		return null;
	}

}

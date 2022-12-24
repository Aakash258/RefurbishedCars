package com.refurbished.cars.rowMappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.refurbished.cars.models.CarsImagesModel;

public class CarsImagesRowMapper implements RowMapper<CarsImagesModel> {

	 @Override
     public CarsImagesModel mapRow(ResultSet resultSet, int i) throws SQLException {
		 CarsImagesModel customer = new CarsImagesModel();
         customer.setCar_id(resultSet.getInt("car_id"));
         customer.setCar_image(resultSet.getString("Car_image"));
         customer.setCar_image_id(resultSet.getInt("Car_image_id"));
        
         return customer;
     }
}



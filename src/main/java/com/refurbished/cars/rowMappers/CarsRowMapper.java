package com.refurbished.cars.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.refurbished.cars.models.CarsModel;

public class CarsRowMapper implements RowMapper<CarsModel> {

	 @Override
     public CarsModel mapRow(ResultSet resultSet, int i) throws SQLException {
		 CarsModel car = new CarsModel();
         car.setCar_id(resultSet.getInt("car_id"));
         car.setSeller_id(resultSet.getInt("seller_id"));
         car.setCar_category(resultSet.getString("car_category"));
         car.setCar_manufactured_year(resultSet.getString("car_manufactured_year"));
         car.setCar_fuel_type(resultSet.getString("car_fuel_type"));
         car.setCar_registration_due_year(resultSet.getString("car_registration_due_year"));
         car.setCar_insurance_due_date(resultSet.getString("car_insurance_due_date"));
         car.setCar_transmission_type(resultSet.getString("car_transmission_type"));
         car.setCar_ad_published_date(resultSet.getString("car_ad_published_date"));
         car.setCar_price(resultSet.getInt("car_price"));
         car.setCar_discounted_price(resultSet.getInt("car_discounted_price"));
         car.setCar_sold(resultSet.getString("car_sold"));
         car.setCar_km_run(resultSet.getInt("car_km_run"));
         car.setCar_rto(resultSet.getString("car_rto"));
         car.setCar_owners_count(resultSet.getInt("car_owners_count"));
         car.setCar_desc(resultSet.getString("car_desc"));
         car.setCar_model(resultSet.getString("car_model"));
         
        
         return car;
     }
}

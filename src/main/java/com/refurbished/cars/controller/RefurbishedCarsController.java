package com.refurbished.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.refurbished.cars.models.CarsModel;
import com.refurbished.cars.rowMappers.CarsRowMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("refurbished/")
public class RefurbishedCarsController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("showcars")
	public List<CarsModel> cars() {
		
		String sql = "select * from cars";
		
		List<CarsModel> cars = jdbcTemplate.query(sql, new CarsRowMapper());
		
		return cars;
	}
	
	@PostMapping("addcars")
	public int addcars(@RequestBody CarsModel carObj) {
		
		String sql = "insert into cars VALUES ("+carObj.getSeller_id()+carObj.getCar_category()+carObj.getCar_model()+carObj.getCar_desc()+carObj.getCar_manufactured_year()+carObj.getCar_fuel_type()+carObj.getCar_registration_due_year()+carObj.getCar_insurance_due_date()+carObj.getCar_transmission_type()+carObj.getCar_ad_published_date()+carObj.getCar_price()+carObj.getCar_discounted_price()+carObj.getCar_sold()+carObj.getCar_owners_count()+carObj.getCar_km_run()+carObj.getCar_rto()+"";
		
		int carsadded = jdbcTemplate.update(sql);
		
		return carsadded;
	}
	
	@DeleteMapping("deletecars")
	public int deletecars(@RequestParam("car_id") String car_id) {
		
		String sql = "delete from cars where car_id = "+car_id+"";
		
		int carsdeleted = jdbcTemplate.update(sql);
		
		return carsdeleted;
	}
	
	@PutMapping("updatecars")
	public int updatecars() {
		
		String sql = "select * from cars";
		
		int carsupdated = jdbcTemplate.update(sql);
		
		return carsupdated;
	}
}

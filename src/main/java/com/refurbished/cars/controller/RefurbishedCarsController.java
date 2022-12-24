package com.refurbished.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refurbished.cars.models.CarsModel;
import com.refurbished.cars.rowMappers.CarsRowMapper;

@RestController
public class RefurbishedCarsController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/showcars")
	public List<CarsModel> cars() {
		
		String sql = "select * from cars";
		
		List<CarsModel> cars = jdbcTemplate.query(sql, new CarsRowMapper());
		
		return cars;
	}
}

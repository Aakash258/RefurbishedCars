package com.refurbished.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refurbished.cars.models.CarsModel;
import com.refurbished.cars.models.SellerDetailsModel;
import com.refurbished.cars.rowMappers.CarsRowMapper;

@RestController
@RequestMapping("/refurbished")
public class RefurbishedCarsController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/showcars")
	public List<CarsModel> cars() {
		
		String sql = "select * from cars";
		
		List<CarsModel> cars = jdbcTemplate.query(sql, new CarsRowMapper());
		
		return cars;
	}

	
//	@PostMapping("/addcars")
//	
//	@DeleteMapping("/deletecar")
//	
//	@PutMapping("/updatecar")

	@PutMapping("/updateSellerDetails")
	public SellerDetailsModel updateSellerDetails(@RequestBody SellerDetailsModel seller) {
		String query = "update seller_details set company_logo = '" + seller.getCompany_logo() + "', company_name='"
				+ seller.getCompany_name() + "', email='" + seller.getEmail() + "', city='" + seller.getCity()
				+ "', state='" + seller.getState() + "', address='" + seller.getAddress() + "', pincode="
				+ seller.getPincode() + ", phone=" + seller.getPhone() + " where seller_id = "
				+ seller.getSeller_id();
		int update = jdbcTemplate.update(query);
		System.out.println("[*] updated: " + update);
		return seller;
		
	}
//	
//	@PutMapping("/sellerLogin")
}

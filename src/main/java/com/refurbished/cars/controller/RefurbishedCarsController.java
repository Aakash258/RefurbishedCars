package com.refurbished.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.refurbished.cars.models.LoginFormModel;
import com.refurbished.cars.models.SellerDetailsModel;
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping("checkLoginCreds")
	public ResponseEntity<?> checkLoginCreds(@RequestBody LoginFormModel loginForm) {
		
		String sql = "select count(*) from seller_credentials where seller_userid='"+loginForm.getUserid()+"' AND seller_password='"+loginForm.getPassword()+"'";

		int seller_var = jdbcTemplate.queryForObject(sql, Integer.class);
		if(seller_var>=1) {
			return ResponseEntity.ok(loginForm);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateSellerDetails")
	public SellerDetailsModel updateSellerDetails(@RequestBody SellerDetailsModel seller) {
		String query = "update seller_details set company_logo = '" + seller.getCompany_logo() + "', company_name='"
				+ seller.getCompany_name() + "', email='" + seller.getEmail() + "', city='" + seller.getCity()
				+ "', state='" + seller.getState() + "', address='" + seller.getAddress() + "', pincode="
				+ seller.getPincode() + ", phone=" + seller.getPhone() + " where seller_id = " + seller.getSeller_id();
		int update = jdbcTemplate.update(query);
		System.out.println("[*] updated: " + update);
		return seller;

	}

	@PostMapping("addcars")
	public int addcars(@RequestBody CarsModel carObj) {

		String sql = "insert into cars VALUES (" + carObj.getSeller_id() + carObj.getCar_category()
				+ carObj.getCar_model() + carObj.getCar_desc() + carObj.getCar_mfg_year()
				+ carObj.getCar_fuel_type() + carObj.getCar_reg_due_year() + carObj.getCar_insurance_due_date()
				+ carObj.getCar_transmission_type() + carObj.getCar_ad_published_date() + carObj.getCar_price()
				+ carObj.getCar_discounted_price() + carObj.getCar_sold() + carObj.getCar_owners_count()
				+ carObj.getCar_km_run() + carObj.getCar_rto() + "";

		int carsadded = jdbcTemplate.update(sql);

		return carsadded;
	}

	@DeleteMapping("deletecars")
	public int deletecars(@RequestParam("car_id") String car_id) {

		String sql = "delete from cars where car_id = " + car_id + "";

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

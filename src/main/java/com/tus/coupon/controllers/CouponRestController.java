package com.tus.coupon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tus.coupon.model.Coupon;
import com.tus.coupon.repos.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

	@Autowired
	CouponRepo repo;

	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon create(@RequestBody Coupon coupon) {

		return repo.save(coupon);

	}
	
	@GetMapping(value = "/mary")
	public String getMsgMary() {
		return "Message from Mary Changed";

	}
	
	@DeleteMapping("/coupons/{id}")
	void deleteCouponById(@PathVariable Long id) {
			repo.deleteById(id);
	}
	
	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public List<Coupon> getAllCoupons() {
		return repo.findAll();

	}
}

package com.hike.customer.service;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hike.customer.CustomeException.AgeOutOfRange;
import com.hike.customer.entity.Customer;
import com.hike.customer.repository.CustomerRepo;

import ch.qos.logback.core.boolex.Matcher;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;

	public Customer saveCustomer(Customer cus) {
		LocalDate dob = cus.getDob();
		int years = dob.compareTo(LocalDate.now());
		int abs = Math.abs(years);

		if (abs >= 18) {
			
			String email = cus.getEmail();
			Pattern p= Pattern.compile("@hikeon.tech");
			java.util.regex.Matcher m=p.matcher(email);

			if (m.find()) {
				cus.setCustomer_group("hikeon");
				System.out.println(cus);
				return repo.save(cus);
			} else {
				String occupation = cus.getOccupation();
				if (occupation.equalsIgnoreCase("developer")) {
					cus.setCustomer_group("developer");
					return repo.save(cus);
				} else if (occupation.equalsIgnoreCase("chef")) {
					cus.setCustomer_group("chef");
					return repo.save(cus);
				} else {
					cus.setCustomer_group("NA");
					return repo.save(cus);

				}
			}

		} else {
			throw new AgeOutOfRange();
		}

	}

}

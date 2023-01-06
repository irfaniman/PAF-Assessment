package vttp2022.paf.assessment.eshop.repositories;

import static vttp2022.paf.assessment.eshop.repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp2022.paf.assessment.eshop.models.Customer;

public class CustomerRepository {

	@Autowired
	private JdbcTemplate template;

	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {
		// TODO: Task 3 

		final List<Customer> custs = new LinkedList<>();
		final String custExists;
	
		final SqlRowSet rs = template.queryForRowSet(SQL_SELECT_CUSTOMERS, name);

		while (rs.next()) {
			custs.add(Customer.create(rs));
		}

		if(custs.isPresent()) {
			custExists = name;
		}

		return custExists;
	}
}


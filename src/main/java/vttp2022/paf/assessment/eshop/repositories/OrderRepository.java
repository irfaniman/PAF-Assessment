package vttp2022.paf.assessment.eshop.repositories;

import static vttp2022.paf.assessment.eshop.repositories.Queries.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	// TODO: Task 3
	
    @Autowired
    private JdbcTemplate template;

    public boolean insertOrder(Order o) {
        return template.update(SQL_INSERT_ORDER,
                o.getOrderId(), o.getName()) > 0;
    }

}


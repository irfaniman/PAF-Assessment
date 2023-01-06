package vttp2022.paf.assessment.eshop.repositories;

import java.util.List;

import static vttp2022.paf.assessment.eshop.repositories.Queries.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;

@Repository
public class LineItemRepository {
    
    @Autowired
    private JdbcTemplate template;

    public void addLineItems(Order o) {
        addLineItems(o.getLineItems());
    }

    public void addLineItems(List<LineItem> lineItems) {
        List<Object[]> data = lineItems.stream()
                .map(li -> {
                    Object[] l = new Object[3];
                    l[0] = li.getQuantity();
                    l[1] = li.getQuantity();
                    return l;
                })
                .toList();
                
        template.batchUpdate(SQL_INSERT_LINE_ITEM, data);
    }
}

package vttp2022.paf.assessment.eshop.controllers;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.http.HttpSession;
import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.repositories.CustomerRepository;

@RestController
@RequestMapping(path = "/api", produces=MediaType.APPLICATION_JSON_VALUE )
public class OrderController {

	@Autowired
	private CustomerRepository custRepo;

	//TODO: Task 3
    @GetMapping(path = "{customerName}")
    public ResponseEntity<String> getCustomerByName(@PathVariable String name) {
        System.out.println("get customer by name");
        JsonObject result = null;
        try {
            // Query the database for the books
            Customer customer = custRepo.findCustomerByName(name);

            // Build the result
            JsonObjectBuilder objBuilder = Json.createObjectBuilder();
            objBuilder.add("customer", customer.toJSON());
            result = objBuilder.build();
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"error\": \"Customer not found\"}");
        }

	}

    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess){

        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        if (null == lineItems) {
            System.out.println("This is a new session");
            System.out.printf("session id = %s\n", sess.getId());
            lineItems = new LinkedList<>();
            sess.setAttribute("cart", lineItems);
        }

        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        lineItems.add(new LineItem(item, quantity));
        Order o = new Order();
        o.setName(form.getFirst("name"));
        for (LineItem li : lineItems)
            System.out.printf("description: %s, quantity: %d\n", li.getItem(), li.getQuantity());
        o.setLineItems(lineItems);

        sess.setAttribute("checkoutCart", o);
        model.addAttribute("lineItems", lineItems);

        return "cart_template";
    }

	@GetMapping(path="/api/order/{customerName}/status")
	public ResponseEntity<String> getDispatchedPendingOrders(@PathVariable String name) {
        JsonObject result = null;
        try {
            
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"status\": \"Pending\"}");
        }
		return null;
	}
}


package vttp2022.paf.assessment.eshop.repositories;

public class Queries {
    
    public static String SQL_SELECT_CUSTOMERS = "select name from customers where name = ?";

    public static String SQL_INSERT_ORDER = "insert into order(orderId, deliveryId, status, orderDate) values (?, ?, ?, SYSDATE())";
    
    public static String SQL_INSERT_LINE_ITEM = "insert into line_item(description, quantity) values (?, ?)";
}

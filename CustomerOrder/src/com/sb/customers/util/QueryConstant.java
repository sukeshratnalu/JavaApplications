package com.sb.customers.util;

public class QueryConstant {
    public static final String CUSTOMER_INSERT_QUERY =
            "INSERT INTO customers(name, mobile, addr, mail, pin, password) VALUES(?, ?, ?, ?, ?,?)";
    public static final String CUSTOMER_UPDATE_QUERY =
            "UPDATE customers SET name = ?, mobile =?, mail =?, addr =?, pin =? WHERE id = ?";
    public static final String CUSTOMER_DELETE_QUERY = "DELETE FROM customers WHERE id = ?";
    public static final String CUSTOMER_SELECT_QUERY = "SELECT id, name, mobile, mail, addr, pin  FROM   customers";
    public static final String CUSTOMER_LOGIN_SELECT_QUERY =
            "SELECT id, name, mobile, mail, addr, pin  FROM customers WHERE name= ? AND password = ?";
}

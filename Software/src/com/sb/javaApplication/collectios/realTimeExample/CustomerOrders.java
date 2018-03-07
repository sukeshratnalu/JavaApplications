package com.sb.javaApplication.collectios.realTimeExample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerOrders {
    public static void main(String args[]) throws IOException {
        Order order = new Order();
        System.out.println("getting order List:");
        Map orderList = new HashMap();
        orderList = order.getOrders();
        System.out.println(orderList);

        System.out.println("getting order Details by ID:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Order ID: ");
        String id = sc.nextLine();
        String orderDetails = order.getOrdersById(id);
        if(orderDetails!=null){
            System.out.println("Your order: "+orderDetails);
        }else{
            System.out.println("Order not exists");
        }
        System.out.println("getting order name list:");
        ArrayList<String> orderNameList = new ArrayList<String>();
        orderNameList = order.getOrderNames();
        System.out.println(orderNameList);
    }
}

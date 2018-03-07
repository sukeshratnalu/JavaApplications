package com.sb.javaApplication.collectios.realTimeExample;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OrderDetails{
  public String Id,Name;
}

public class Order {
  /**
   * listing orders
   * @return
   * @throws IOException
   */
  public Map getOrders() throws IOException{
    String reader = new String(Files.readAllBytes(Paths
      .get("/home/semanticbits/IdeaProjects/CustomerOrder/src/oredrDetails.json")));
    OrderDetails[] orders = new Gson().fromJson(reader, OrderDetails[].class);
    Map ordersList = new HashMap();
    for(int i = 0; i< orders.length; i++){
      ordersList.put(orders[i].Id,orders[i].Name);
    }
    return ordersList;
  }

  /**
   * get order by ID
   * @param id
   * @return
   * @throws IOException
   */
  public String getOrdersById(String id) throws IOException{
    Map map = getOrders();
    String orderDetails = "";
    /*
    handaling NullPointerException if Details not present for specific
     */
    try{
      orderDetails = map.get(id).toString();
    }catch (NullPointerException e){
      orderDetails = null;
    }
    return orderDetails;
  }

  /**
   * getting all oredr names
   * @return
   * @throws IOException
   */
  public ArrayList getOrderNames() throws  IOException{
    ArrayList orderNameList = new ArrayList();
    Map map = getOrders();
    Object orderList[] = map.values().toArray();
    for(int i =0; i< orderList.length; i++){
      orderNameList.add(orderList[i]);
    }
    return  orderNameList;
  }

}

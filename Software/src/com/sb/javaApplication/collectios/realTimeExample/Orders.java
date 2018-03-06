package com.sb.javaApplication.collectios.realTimeExample;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Orders {
    public void listOredrDetails() throws IOException{

            FileReader freader = new FileReader("/home/semanticbits/IdeaProjects/JavaApplications/Software/src/com/sb/javaApplication/collectios/realTimeExample/orderDetails.txt");
            BufferedReader br = new BufferedReader(freader);
            String s;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            freader.close();


    }

    public static void main(String args[]) throws IOException{
        Orders orders = new Orders();
        orders.listOredrDetails();
    }
}

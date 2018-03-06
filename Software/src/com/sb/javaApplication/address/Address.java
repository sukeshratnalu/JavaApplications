package com.sb.javaApplication.address;

public class Address {
    public void getAddress(String houseNo, String dist, String state, int pinCode){
        System.out.println("House No : " + houseNo);
        System.out.println("Dist : " + dist);
        System.out.println("State : " + state);
        System.out.println("PIN : " + pinCode);
    }
    protected void getMobileNo(){
        System.out.println("getting phone number from Address Class");
    }
}

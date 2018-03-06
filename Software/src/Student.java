import com.sb.javaApplication.address.Address;

public class Student extends Address {

    void getPersonalDetails(String name, int age, String gender, String email){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Gender : " + gender);
        System.out.println("email : " + email);

    }

    public void getMobileNo(int no){
        System.out.println("getting phone number from Student Class: "+no);
        //super.getMobileNo();
    }



}

import java.util.Scanner;

public class Test {
    static String name ;
    String getData(String userName){
        String data = userName;
        return data;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        Test obj = new Test();
        System.out.println("User entered " + obj.getData(name));
        //testing student class
        Student student = new Student();
        student.getPersonalDetails(name,26,"M","sukesh@gmail.com");
        student.getAddress("AD101","Rayagada","ODISHA",765019);
    }
}

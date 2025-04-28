import java.rmi.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try
        {
            String serverUrl = "rmi://localhost/server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverUrl);

            double num1,num2;
            System.out.println("Enter first number");
            num1 = sc.nextDouble();

            System.out.println("Enter second number");
            num2 = sc.nextDouble();

            System.out.printf("Entered numbers: %f %f%n",num1,num2);
            System.out.println("------Results-------");

            System.out.printf("Addition of %f and %f is: %f %n", num1,num2,serverIntf.Add(num1,num2));
            System.out.printf("Subtraction of %f from %f is: %f %n", num2,num1,serverIntf.Sub(num1,num2));
            System.out.printf("Multiplication of %f and %f is: %f %n", num1,num2,serverIntf.Multi(num1,num2));
            System.out.printf("Division of %f and %f is: %f %n", num1,num2,serverIntf.Division(num1,num2));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
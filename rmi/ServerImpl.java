import java.rmi.*;
import java.rmi.server.*;
public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
    public ServerImpl() throws RemoteException{
        try {
            System.out.println("Object Initialised");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public double Add(double num1, double num2) throws RemoteException{
        return num1 + num2;
    }
    public double Sub(double num1, double num2) throws RemoteException{
        return num1 - num2;
    }
    public double Multi(double num1, double num2) throws RemoteException{
        return num1*num2;
    }
    public double Division(double num1, double num2) throws RemoteException{
        try{
            double quo =  num1/num2;
            return quo;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Division by 0 not possible.");
            return -1;
        }
    }
}
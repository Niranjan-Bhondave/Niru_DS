import java.rmi.*;
public interface ServerIntf extends Remote{
    public double Add(double num1, double num2) throws RemoteException;
    public double Sub(double num1, double num2) throws RemoteException;
    public double Multi(double num1, double num2) throws RemoteException;
    public double Division(double num1, double num2) throws RemoteException;
}
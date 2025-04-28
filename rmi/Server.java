import java.rmi.*;
public class Server {
    public static void main(String[] args) {
        try{
            ServerImpl serverImpl = new ServerImpl();
            Naming.rebind("server",serverImpl);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
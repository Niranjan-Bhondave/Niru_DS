import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter number of nodes in the system");
        n = sc.nextInt();

        System.out.println("Ring is formed as follows:");
        for(int i=0;i<n;i++){
            System.out.printf("%d -> ", i);
        }
        System.out.println(0);

        int ch = 0;
        do {
            int sender,receiver;
            System.out.println("Enter sender");
            sender = sc.nextInt();

            System.out.println("Enter receiver");
            receiver = sc.nextInt();

            System.out.println("Enter data to be sent");
            String data = sc.next();

            int recipient = (sender + 1)%n;
            while(true){
                System.out.printf("Token received  by %d %n",receiver);
                if(recipient == receiver){
                    System.out.println("Recipient is receiver");
                    System.out.println("Message:" + data);
                    System.out.println("Any more messages to be sent ? 1 for yes, 0 for no");
                    ch = sc.nextInt();
                    break;
                }

                else {
                    System.out.println("Recipient is not the receiver. Passing token to next node.");
                    System.out.println("*".repeat(10));
                    recipient = (recipient + 1)%n;
                }
            }
        }while(ch != 0);
    }
}

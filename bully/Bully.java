import java.util.Scanner;

public class Bully {
    static boolean state[] = new boolean[5];
    int coordinator;
    public static void up(int up){
        if(state[up-1]) System.out.printf("Process %d is already up",up);
        else {
            state[up-1]=true;
            System.out.printf("Process %d held election",up);
            for(int i = up;i < 5;i++) System.out.printf("Election message sent from process %d to %d",i,i+1);
            for(int i = up+1;i<=5;i++){
                if(state[i]) System.out.printf("Alive message sent from process %d to %d",i,up);
                break;
            }
        }
    }

    public static void down(int down){
        if(!state[down-1]) System.out.printf("Process %d is already down",down);
        else state[down-1] = false;
    }

    public static void mess(int mess){
        if(!state[mess-1]) System.out.printf("Process %d is down",mess);
        else {
            if(state[4]) System.out.println("OK");
            else {
                System.out.printf("Process %d election",mess);
                for(int i = mess;i<5;i++) System.out.printf("Election send from %d to %d", mess,i+1);
                for(int i = 5;i>=mess;i--){
                    if(state[i-1]) System.out.printf("Coordinator message send from process %d to all other processes",i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++)state[i] = true;
        System.out.println("All processes are up. Process 5 is coordinator.");
        do {
            System.out.println("1 up a process.");
            System.out.println("2.down a process");
            System.out.println("3 send a message");
            System.out.println("4.Exit");
            choice = sc.nextInt();

            switch(choice){
                case 1: {
                    System.out.println("bring proces up");
                    int up = sc.nextInt();
                    if (up == 5) {
                        System.out.println("process 5 is co-ordinator");
                        Bully.state[4] = true;
                        break;
                    }
                    Bully.up(up);
                    break;
                }

                case 2:
                {
                    System.out.println("bring down any process.");
                    int down = sc.nextInt();
                    Bully.down(down);
                    break;
                }

                case 3:
                {
                    System.out.println("which process will send message");
                    int mess = sc.nextInt();
                    Bully.mess(mess);
                }
            }
        }while(choice == 4);
    }
}

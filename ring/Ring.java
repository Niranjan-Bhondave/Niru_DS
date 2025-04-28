import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {
        class Rr{
            public int index;
            public int id;
            public int f;
            public String state;


        }

        Rr proc[] = new Rr[10];
        for(int i=0;i<proc.length;i++)proc[i] = new Rr();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes");
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            proc[i].index = i;
            System.out.println("Enter the id of process : ");
            proc[i].id = sc.nextInt();
            proc[i].state = "active";
            proc[i].f = 0;
        }
        for(int i=0;i<num-1;i++){
            for(int j = 0;j<num-1;j++){
                if (proc[j].id > proc[j + 1].id) {
                    int temp = proc[j].id;
                    proc[j].id = proc[j + 1].id;
                    proc[j + 1].id = temp;
                }
            }
        }

        int init;
        int ch;
        int temp1;
        int temp2;
        int ch1;
        int arr[] = new int[10];
        proc[num - 1].state = "inactive";
        System.out.println("\n process " + proc[num - 1].id + "select as co-ordinator");

        while(true){
            System.out.println("\n 1.election 2.quit ");
            ch = sc.nextInt();
            for (int i = 0; i < num; i++) {
                proc[i].f = 0;
            }

            switch(ch){
                case 1:
                    System.out.println("\n Enter the Process number who initialsied election : ");
                    init = sc.nextInt();
                    temp2 = init;
                    temp1 = init + 1;
                    int i = 0;
                    while (temp2 != temp1) {
                        if ("active".equals(proc[temp1].state) && proc[temp1].f == 0) {
                            System.out.println("\nProcess " + proc[init].id + "send message to " + proc[temp1].id);
                            proc[temp1].f = 1;
                            init = temp1;
                            arr[i] = proc[temp1].id;
                            i++;
                        }
                        if (temp1 == num) {
                            temp1 = 0;
                        } else {
                            temp1++;
                        }
                    }
                    System.out.println("\nProcess " + proc[init].id + " send message to " + proc[temp1].id);
                    arr[i] = proc[temp1].id;
                    i++;
                    int max = -1;
                    for (int j = 0; j < i; j++) {
                        if (max < arr[j]) {
                            max = arr[j];
                        }
                    }
                    System.out.println("\n process " + max + "select as co-ordinator");
                    for (int j = 0; j < num; j++) {
                        if (proc[j].id == max) {
                            proc[j].state = "inactive";
                        }
                    }
                    break;

                case 2:
                    System.out.println("Program terminated ...");
                    return;
                default:
                    System.out.println("\n invalid response \n");
                    break;
            }
        }
    }
}

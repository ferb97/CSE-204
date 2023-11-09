import java.util.Scanner;

public class Main {

    public static void print(Queue<Integer> queue){
        int n = queue.length();
        Queue<Integer> temp = new Array<Integer>();
        System.out.print("<");
        for(int i = 0; i < n - 1; i++){
            //System.out.print(queue.frontValue() + " ");
            temp.enqueue(queue.dequeue());
            System.out.print(temp.rearValue() + " ");
        }
        if(n != 0) {
            temp.enqueue(queue.dequeue());
            System.out.print(temp.rearValue());
        }
        System.out.println(">");
        for(int i = 0; i < n; i++){
            queue.enqueue(temp.dequeue());
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a =  new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        //Queue<Integer> queue = new Array<Integer>(n);
        Queue<Integer> queue = new LinkedList<Integer>(n);

        for(int i = 0; i < n; i++){
            queue.enqueue(a[i]);
        }

        print(queue);

        while(true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
            if (q == 0) {
                break;
            } else if (q == 1) {
                queue.clear();
                print(queue);
                System.out.println("-1");
            } else if (q == 2) {
                queue.enqueue(p);
                print(queue);
                System.out.println("-1");
            } else if (q == 3) {
                Integer it = queue.dequeue();
                print(queue);
                System.out.println(it);
            } else if (q == 4) {
                print(queue);
                System.out.println(queue.length());
            } else if (q == 5) {
                print(queue);
                System.out.println(queue.frontValue());
            } else if (q == 6) {
                print(queue);
                System.out.println(queue.rearValue());
            }
            else if (q == 7) {
                Integer it = queue.leaveQueue();
                print(queue);
                System.out.println(it);
            }
        }
    }
}

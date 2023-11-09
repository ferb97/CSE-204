import java.util.Scanner;

public class Main {

    public static void print(Stack<Integer> stack, int stackSize){
        Integer[] temp = new Integer[stackSize];
        for(int i = 0; i < stackSize; i++){
            Integer it = (Integer)stack.pop();
            temp[i] = it;
        }
        System.out.print("<");
        for(int i = stackSize - 1; i > 0; i--){
            System.out.print(temp[i] + " ");
        }
        if(stackSize >= 1){
            System.out.print(temp[0]);
        }
        System.out.println(">");
        for(int i = stackSize - 1; i >= 0; i--){
            stack.push(temp[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a =  new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }
        //Stack<Integer> stack = new Array<Integer>(n,1);
        Stack<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            stack.push(a[i]);
        }

        print(stack, stack.length());
        /*
        System.out.println(stack.length());
        System.out.println(stack.pop());
        print(stack, stack.length());
        System.out.println(stack.topValue());
        System.out.println(stack.length());
        stack.push(6);
        stack.push(10);
        stack.push(15);
        print(stack, stack.length());
        //stack.setDirection(1);
        System.out.println(stack.topValue());
        print(stack, stack.length());
        */

        while(true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
            if (q == 0) {
                break;
            } else if (q == 1) {
                stack.clear();
                print(stack, stack.length());
                System.out.println("-1");
            } else if (q == 2) {
                stack.push(p);
                print(stack, stack.length());
                System.out.println("-1");
            } else if (q == 3) {
                Integer it = stack.pop();
                print(stack, stack.length());
                System.out.println(it);
            } else if (q == 4) {
                print(stack, stack.length());
                System.out.println(stack.length());
            } else if (q == 5) {
                print(stack, stack.length());
                System.out.println(stack.topValue());
            } else if (q == 6) {
                stack.setDirection(p);
                print(stack, stack.length());
                System.out.println("-1");
            }
        }
    }
}

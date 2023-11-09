import java.util.Scanner;

public class DishwasherMain {

    public static void printStack(Stack<Integer> stack, int stackSize){
        Integer[] temp = new Integer[stackSize];
        for(int i = 0; i < stackSize; i++){
            Integer it = (Integer)stack.pop();
            temp[i] = it;
        }
        for(int i = stackSize - 1; i > 0; i--){
            System.out.print(temp[i] + ",");
        }
        if(stackSize != 0){
            System.out.print(temp[0]);
        }
        System.out.println();
        for(int i = stackSize - 1; i >= 0; i--){
            stack.push(temp[i]);
        }
    }

    public static void main(String[] args) {
        int n, x;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        x = scn.nextInt();
        int[] courseTime = new int[x + 1];
        for(int i = 1; i <= x; i++){
            courseTime[i] = scn.nextInt();
        }
        Dish[] dishArray = new Dish[n * x];
        //Stack<Dish> dirtyStack = new Array<Dish>(dishArray, 1);
        //Stack<Dish> cleanStack = new Array<Dish>(dishArray, -1);
        //Stack<Dish> dirtyStack = new Array<Dish>();
        //Stack<Dish> cleanStack = new Array<Dish>();
        Stack<Dish> dirtyStack = new LinkedList<Dish>();
        Stack<Dish> cleanStack = new LinkedList<Dish>();
        Stack<Integer> endTimeStack = new LinkedList<Integer>();
        Stack<PersonTime> personStack = new LinkedList<PersonTime>();
        int lastTime = 0;
        while(true){
            int k = scn.nextInt();
            int t = scn.nextInt();
            int s = scn.nextInt();
            if(k == 0)
               break;
            if(s == x){
               PersonTime personTime = new PersonTime(k,t);
               personStack.push(personTime);
            }
            while(dirtyStack.length() > 0 && lastTime < t){
                Dish it = dirtyStack.pop();
                cleanStack.push(it);
                lastTime = lastTime + it.getWashingTime();
                endTimeStack.push(lastTime - 1);
            }
            if(lastTime < t)
               lastTime = t;
            Dish d = new Dish(s, courseTime[s]);
            dirtyStack.push(d);
        }
        while(dirtyStack.length() > 0){
            Dish it = dirtyStack.pop();
            cleanStack.push(it);
            lastTime = lastTime + it.getWashingTime();
            endTimeStack.push(lastTime - 1);
        }
        System.out.println(endTimeStack.topValue());
        printStack(endTimeStack, endTimeStack.length());
        if(personStack.length() == n){
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }
        while(personStack.length() > 1){
            System.out.print(personStack.pop().getPerson() + ",");
        }
        if(personStack.length() == 1){
            System.out.print(personStack.pop().getPerson());
        }
        System.out.println();
    }

}

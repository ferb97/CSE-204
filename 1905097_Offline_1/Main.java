import java.util.Scanner;

public class Main {

    public static void print(List<Integer> list){
        if(list.length() == 0){
            System.out.println("<>");
            return;
        }
        int k = list.currPos();
        System.out.print("<");
        for(list.moveToStart();list.currPos() < list.length() - 1; list.next()){
            if(k == list.currPos()){
               System.out.print("| ");
            }
            System.out.print(list.getValue() + " ");
        }
        if(k == list.length() - 1){
           System.out.print("| ");
        }
        System.out.println(list.getValue() + ">");
        list.moveToPos(k);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int listSize = scn.nextInt();
        int chunkSize = scn.nextInt();
        Integer []a = new Integer[listSize];
        for(int i = 0; i < listSize; i++){
            a[i] = scn.nextInt();
        }
        //List<Integer> list = new Array<Integer>(chunkSize,a,listSize);
        List<Integer> list = new LinkedList<Integer>(listSize,a);
        print(list);
        while(true){
            int q = scn.nextInt();
            int p;
            if(q == 0){
               p = scn.nextInt();
               break;
            }
            else if(q == 1){
               p = scn.nextInt();
               list.clear();
               print(list);
               System.out.println("-1");
            }
            else if(q == 2){
                p = scn.nextInt();
                list.insert(p);
                print(list);
                System.out.println("-1");
            }
            else if(q == 3){
                p = scn.nextInt();
                list.append(p);
                print(list);
                System.out.println("-1");
            }
            else if(q == 4){
                p = scn.nextInt();
                Integer s = (Integer)list.remove();
                print(list);
                System.out.println(s);
            }
            else if(q == 5){
                p = scn.nextInt();
                list.moveToStart();
                print(list);
                System.out.println("-1");
            }
            else if(q == 6){
                p = scn.nextInt();
                list.moveToEnd();
                print(list);
                System.out.println("-1");
            }
            else if(q == 7){
                p = scn.nextInt();
                list.prev();
                print(list);
                System.out.println("-1");
            }
            else if(q == 8){
                p = scn.nextInt();
                list.next();
                print(list);
                System.out.println("-1");
            }
            else if(q == 9){
                p = scn.nextInt();
                print(list);
                System.out.println(list.length());
            }
            else if(q == 10){
                p = scn.nextInt();
                print(list);
                System.out.println(list.currPos());
            }
            else if(q == 11){
                p = scn.nextInt();
                list.moveToPos(p);
                print(list);
                System.out.println("-1");
            }
            else if(q == 12){
                p = scn.nextInt();
                print(list);
                if(list.getValue() == null)
                    System.out.println("-1");
                else
                    System.out.println(list.getValue());
            }
            else if(q == 13){
                p = scn.nextInt();
                print(list);
                System.out.println(list.Search(p));
            }
        }
    }
}

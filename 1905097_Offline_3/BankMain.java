import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {
        //Queue<Integer> queue1 = new Array<Integer>();
        //Queue<Integer> queue2 = new Array<Integer>();
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        Integer t1 = 0, t2 = 0;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 0; i < n; i++){
            Integer time = scn.nextInt();
            Integer serviceTime = scn.nextInt();
            if(t1 < time || t2 < time){
               while(t1 < time || t2 < time){
                   if(queue1.length() == 0 && queue2.length() == 0){
                       break;
                   }
                   else if(queue1.length() == 1 && queue2.length() == 0 && t2 < t1){
                       t2 = t2 + queue1.dequeue();
                       //System.out.println("2 " + t2);
                   }
                   else if(queue2.length() == 1 && queue1.length() == 0 && t1 < t2){
                       t1 = t1 + queue2.dequeue();
                       //System.out.println("1 " + t1);
                   }
                   else if(t1 <= t2 && queue1.length() > 0){
                      t1 = t1 + queue1.dequeue();
                      //System.out.println("1 " + t1);
                      if(queue1.length() < queue2.length() - 1){

                         queue1.enqueue(queue2.leaveQueue());
                      }
                   }
                   else if(t2 <= t1 && queue2.length() > 0){
                       t2 = t2 + queue2.dequeue();
                       //System.out.println("2 " + t2);
                       if(queue2.length() < queue1.length() - 1){
                           queue2.enqueue(queue1.leaveQueue());
                       }
                   }
                   else if(queue1.length() > 0){
                       t1 = t1 + queue1.dequeue();
                       //System.out.println("1 " + t1);
                       if(queue1.length() < queue2.length() - 1){
                           queue1.enqueue(queue2.leaveQueue());
                       }
                   }
                   else if(queue2.length() > 0){
                       t2 = t2 + queue2.dequeue();
                       //System.out.println("2 " + t2);
                       if(queue2.length() < queue1.length() - 1){
                           queue2.enqueue(queue1.leaveQueue());
                       }
                   }
               }
            }
            if(queue1.length() == 0 && t1 <= time){
               t1 = time + serviceTime;
               //System.out.println("1 " + t1);
            }
            else if(queue2.length() == 0 && t2 <= time){
                t2 = time + serviceTime;
                //System.out.println("2 " + t2);
            }
            else if(queue1.length() <= queue2.length()){
               queue1.enqueue(serviceTime);
            }
            else{
               queue2.enqueue(serviceTime);
            }
        }
        while(true){
            if(t1 <= t2 && queue1.length() > 0){
                t1 = t1 + queue1.dequeue();
                //System.out.println("1 " + t1);
                if(queue1.length() < queue2.length() - 1){
                    queue1.enqueue(queue2.leaveQueue());
                }
            }
            else if(t2 <= t1 && queue2.length() > 0){
                t2 = t2 + queue2.dequeue();
                //System.out.println("2 " + t2);
                if(queue2.length() < queue1.length() - 1){
                    queue2.enqueue(queue1.leaveQueue());
                }
            }
            else if(queue1.length() > 0){
                t1 = t1 + queue1.dequeue();
                //System.out.println("1 " + t1);
                if(queue1.length() < queue2.length() - 1){
                    queue1.enqueue(queue2.leaveQueue());
                }
            }
            else if(queue2.length() > 0){
                t2 = t2 + queue2.dequeue();
                //System.out.println("2 " + t2);
                if(queue2.length() < queue1.length() - 1){
                    queue2.enqueue(queue1.leaveQueue());
                }
            }
            if(queue1.length() == 0 && queue2.length() == 0){
                break;
            }
        }
        System.out.println("Booth 1 finishes service at t=" + t1);
        System.out.println("Booth 2 finishes service at t=" + t2);
    }
}

import java.util.Scanner;

public class TNL<E> {
     private List<E> rs;
     private List<E> bs;
     private List<E> ts;

     TNL(E[] rickshaw, E[] bus, E[] train, int rssize, int bssize, int tssize){
         //rs = new Array<E>();
         //bs = new Array<E>();
         //ts = new Array<E>();
         rs = new LinkedList<E>();
         bs = new LinkedList<E>();
         ts = new LinkedList<E>();
         for(int i = 0; i < rssize; i++){
             rs.append(rickshaw[i]);
         }

         for(int i = 0; i < bssize; i++){
             bs.append(bus[i]);
         }

         for(int i = 0; i < tssize; i++){
             ts.append(train[i]);
         }
     }

     public void setRs(List<E> list){
         rs = list;
     }

    public void setBs(List<E> list){
        bs = list;
    }

    public void setTs(List<E> list){
        ts = list;
    }

    public List<E> getRs(){
        return rs;
    }

    public List<E> getBs(){
        return bs;
    }

    public List<E> getTs(){
        return ts;
    }

    public static void printList(List<Integer> list, int size){
        list.moveToStart();
        System.out.print("0");
        for(Integer i = 1; i < size; i++){
            System.out.print(",");
            if(list.Search(i) != -1) {
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rickshawSize = scn.nextInt();
        Integer[] rickshaw = new Integer[rickshawSize];
        for(int i = 0; i < rickshawSize; i++){
            rickshaw[i] = i;
        }
        int busSize = scn.nextInt();
        Integer[] bus = new Integer[busSize];
        for(int i = 0; i < busSize; i++){
            bus[i] = scn.nextInt();
        }
        int trainSize = scn.nextInt();
        Integer[] train = new Integer[trainSize];
        for(int i = 0; i < trainSize; i++){
            train[i] = scn.nextInt();
        }
        TNL<Integer> tnl = new TNL<Integer>(rickshaw, bus, train, rickshawSize, busSize, trainSize);
        int task = scn.nextInt();
        if(task == 1) {
            printList(tnl.getRs(), rickshawSize);
            printList(tnl.getBs(), rickshawSize);
            printList(tnl.getTs(), rickshawSize);
        }
    }

}

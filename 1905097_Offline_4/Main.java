import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String args[]) {
        try {
            File file = new File("Input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            BST<Integer, Integer> bst = new BST<Integer, Integer>();
            while((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                if(arr[0].compareTo("I") == 0){
                    Integer n = Integer.parseInt(arr[1]);
                    bst.insert(n, n);
                    bst.printBinaryTree();
                }
                else if(arr[0].compareTo("D") == 0){
                    Integer n = Integer.parseInt(arr[1]);
                    if(bst.remove(n) == null)
                        System.out.print("Invalid Operation");
                    else
                        bst.printBinaryTree();
                }
                else if(arr[0].compareTo("F") == 0){
                    Integer n = Integer.parseInt(arr[1]);
                    if(bst.find(n) == null)
                        System.out.print("False");
                    else
                        System.out.print("True");
                }
                else if(arr[0].compareTo("T") == 0){
                    if(arr[1].compareTo("In") == 0){
                        bst.printInOrder();
                    }
                    else if(arr[1].compareTo("Pre") == 0){
                        bst.printPreOrder();
                    }
                    if(arr[1].compareTo("Post") == 0){
                        bst.printPostOrder();
                    }
                }
                System.out.println();
            }
            fr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

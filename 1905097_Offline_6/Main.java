import java.io.*;
import java.util.*;

public class Main {

    public static List<Integer>[] buildUpAdjacencyList(int n, int x, Node[] nodes){

        List<Integer>[] adjacencyList = new List[x + 1];
        for(int i = 0; i <= x; i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= x; i++){

            if(nodes[i].getSnakeLadderJump() != -1){
                adjacencyList[i].add(nodes[i].getSnakeLadderJump());
                continue;
            }

            for(int j = 1; j <= n && j + i <= x; j++){
                adjacencyList[i].add(i + j);
            }

        }
        return adjacencyList;
    }

    public static void bfs(List<Integer>[] adjacencyList, Node[] nodes){

        Queue<Node> queue = new LinkedList<>();

        nodes[1].setColor(Node.GRAY);
        nodes[1].setDistance(0);
        queue.add(nodes[1]);

        while(!queue.isEmpty()){

            Node node = queue.remove();
            int nodeNumber = node.getNumber();

            for(int i = 0; i < adjacencyList[nodeNumber].size(); i++){
                int nodeNumber1 = adjacencyList[nodeNumber].get(i);

                if(nodes[nodeNumber1].getColor() == Node.WHITE) {
                    nodes[nodeNumber1].setColor(Node.GRAY);
                    nodes[nodeNumber1].setParent(nodeNumber);
                    if (nodes[nodeNumber].getSnakeLadderJump() != -1)
                        nodes[nodeNumber1].setDistance(nodes[nodeNumber].getDistance());
                    else
                        nodes[nodeNumber1].setDistance(nodes[nodeNumber].getDistance() + 1);
                    queue.add(nodes[nodeNumber1]);
                }
            }

            nodes[nodeNumber].setColor(Node.BLACK);
        }
    }

    public static List<Integer> buildUpShortestPath(Node[] nodes, int x){

        List<Integer> shortestPath = new ArrayList<>();
        int curr = x;
        while (nodes[curr].getParent() != -1) {
            shortestPath.add(curr);
            curr = nodes[curr].getParent();
        }
        shortestPath.add(1);
        Collections.reverse(shortestPath);
        return shortestPath;

    }

    public static List<Integer> buildUpNotReachable(Node[] nodes, int x){
        List<Integer> notReachable = new ArrayList<>();
        for(int i = 1; i <= x; i++){
            if(nodes[i].getColor() == Node.WHITE){
               notReachable.add(i);
            }
        }
        return notReachable;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("Input.txt");
        File outputFile = new File("Output.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        int testcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testcase; t++) {

            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);

            int ladderNumber = Integer.parseInt(br.readLine());
            int[] ladderStart = new int[ladderNumber];
            int[] ladderEnd = new int[ladderNumber];

            for (int i = 0; i < ladderNumber; i++) {
                s = br.readLine().split(" ");
                ladderStart[i] = Integer.parseInt(s[0]);
                ladderEnd[i] = Integer.parseInt(s[1]);
            }

            int snakeNumber = Integer.parseInt(br.readLine());
            int[] snakeStart = new int[snakeNumber];
            int[] snakeEnd = new int[snakeNumber];

            for (int i = 0; i < snakeNumber; i++) {
                s = br.readLine().split(" ");
                snakeStart[i] = Integer.parseInt(s[0]);
                snakeEnd[i] = Integer.parseInt(s[1]);
            }

            Node[] nodes = new Node[x + 1];
            for (int i = 1; i <= x; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < ladderNumber; i++) {
                nodes[ladderStart[i]].setSnakeLadderJump(ladderEnd[i]);
            }

            for (int i = 0; i < snakeNumber; i++) {
                nodes[snakeStart[i]].setSnakeLadderJump(snakeEnd[i]);
            }

            List<Integer>[] adjacencyList = buildUpAdjacencyList(n, x, nodes);

            bfs(adjacencyList, nodes);

            if (nodes[x].getDistance() != -1) {
                bw.write(nodes[x].getDistance() + "\n");

                List<Integer> shortestPath = buildUpShortestPath(nodes, x);
                for (int i = 0; i < shortestPath.size() - 1; i++) {
                    bw.write(shortestPath.get(i) + " -> ");
                }
                bw.write(x + "\n");

            } else {
                bw.write("-1\n");
                bw.write("No solution\n");
            }

            List<Integer> notReachable = buildUpNotReachable(nodes, x);

            if (notReachable.size() == 0) {
                bw.write("All reachable\n");
            } else {
                for (Integer integer : notReachable) {
                    bw.write(integer + " ");
                }
                bw.write("\n");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}

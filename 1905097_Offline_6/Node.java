public class Node {

    public static final int WHITE = 0;
    public static final int GRAY = 1;
    public static final int BLACK = 2;

    private int number;
    private int color;
    private int distance;
    private int parent;
    private int snakeLadderJump;

    public Node(){
        number = 0;
        color = WHITE;
        distance = -1;
        parent = -1;
        snakeLadderJump = -1;
    }

    public Node(int number){
        this.number = number;
        color = WHITE;
        distance = -1;
        parent = -1;
        snakeLadderJump = -1;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getSnakeLadderJump() {
        return snakeLadderJump;
    }

    public void setSnakeLadderJump(int snakeLadderJump) {
        this.snakeLadderJump = snakeLadderJump;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/17.
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 * 随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 */
public class Main {

    private static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int finalCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        boolean[] mark = new boolean[count];
        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i ++) {
            nodes[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }
        dispatch(mark, nodes, -1, count, 0, 0);
        System.out.println(finalCount);
    }

    private static void dispatch(boolean[] mark, Node[] nodes, int curr, int count, int step, int cost) {
        if (step > count) {
            finalCount = Math.min(finalCount, cost + Math.abs(nodes[curr].x) + Math.abs(nodes[curr].y));
            return;
        }
        if (curr >= 0 && mark[curr]) return;
        if (curr >= 0) mark[curr] = true;
        for (int i = 0; i < count; i++) {
            dispatch(mark, nodes, i, count, step + 1, cost + (curr < 0 ? Math.abs(nodes[i].x) + Math.abs(nodes[i].y) : nodesDistance(nodes[i], nodes[curr])));
        }
        if (curr >= 0) mark[curr] = false;
    }

    public static int nodesDistance(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }
}

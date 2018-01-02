package me.magurmach.challenge;

import me.magurmach.challenge.graph.Graph;
import me.magurmach.challenge.graph.Node;
import me.magurmach.challenge.graph.algorithm.MyDFS;
import me.magurmach.challenge.util.Hasher;
import me.magurmach.challenge.util.IntPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shakib Ahmed on 1/1/18.
 */
public class Main {

    private static ArrayList<ArrayList<Node>> nodeGrid;
    private static int directionX[] = {0, 0, 1, -1};
    private static int directionY[] = {1, -1, 0, 0};

    public static void processFile(String fileName) throws FileNotFoundException {
        Scanner in;
        in = new Scanner(new File(fileName));
        int x, y;
        x = in.nextInt();
        y = in.nextInt();

        Hasher.MAXIMUM_WIDTH = y;

        nodeGrid = new ArrayList<>();

        int i, j;
        for (i = 0; i < x; i++) {
            nodeGrid.add(new ArrayList<>());
            for (j = 0; j < y; j++) {
                int value = in.nextInt();
                nodeGrid.get(i).add(new Node(i, j, value));
            }
        }
        in.close();
    }

    private static boolean inRange(int x, int a, int b) {
        return a <= x && x <= b;
    }

    private static Graph processGrid() {
        Graph graph = new Graph();
        int i, j, k;
        for (i = 0; i < nodeGrid.size(); i++) {
            for (j = 0; j < nodeGrid.get(i).size(); j++) {
                for (k = 0; k < directionX.length; k++) {
                    int nx = i + directionX[k];
                    int ny = j + directionY[k];
                    if (inRange(nx, 0, nodeGrid.size() -1) && inRange(ny, 0, nodeGrid.get(i).size() - 1)
                            && nodeGrid.get(i).get(j).getValue() > nodeGrid.get(nx).get(ny).getValue()) {
                        graph.addAdjacency(nodeGrid.get(i).get(j), nodeGrid.get(nx).get(ny));
                    }
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        String fileName = "test.txt";

        if (args.length >= 2 && args[0].equals("-i")) {
            fileName = args[1];
        }

        try {
            processFile(fileName);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        Graph graph = processGrid();

        MyDFS solver = new MyDFS(graph);

        IntPair result = solver.getMaximumDepthWithMaximumDrop();
        System.out.printf("Maximum distance = %d, Maximum drop = %d\n",result.getFirst(), result.getSecond());
        System.out.printf("So, I guess I should mail to %d%d@redmart.com! " +
                        "I find this challenge to be exciting! Thanks!\n",
                result.getFirst(), result.getSecond());
    }
}

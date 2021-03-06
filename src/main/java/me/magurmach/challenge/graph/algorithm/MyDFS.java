package me.magurmach.challenge.graph.algorithm;

import me.magurmach.challenge.graph.Graph;
import me.magurmach.challenge.graph.Node;
import me.magurmach.challenge.util.IntPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Shakib Ahmed on 1/1/18.
 */
public class MyDFS {
    private Graph graph;

    private HashMap<Node, IntPair> depthMemo;

    public MyDFS(Graph graph) {
        this.graph = graph;
        depthMemo = new HashMap<>();
    }

    private IntPair dfs(Node node) {

        if (!depthMemo.containsKey(node)) {
            int maxDept, minValue;
            maxDept = 1;
            minValue = Integer.MAX_VALUE;
            ArrayList<Node> adjacencyList = graph.getAdjacency(node);

            if (adjacencyList != null) {
                for (Node newNode : adjacencyList) {
                    IntPair newNodeDfsReturnValue = dfs(newNode);
                    if (maxDept < newNodeDfsReturnValue.getFirst() + 1) {
                        maxDept = newNodeDfsReturnValue.getFirst() + 1;
                        minValue = newNodeDfsReturnValue.getSecond();
                    } else if (maxDept == newNodeDfsReturnValue.getFirst() + 1) {
                        minValue = Math.min(minValue, newNodeDfsReturnValue.getSecond());
                    }
                }
            }

            if (maxDept == 1) minValue = node.getValue();

            depthMemo.put(node, new IntPair(maxDept, minValue));
        }

        return depthMemo.get(node);
    }

    public IntPair getMaximumDepthWithMaximumDrop() {
        int maxDepth, maxDrop;
        Set<Node> nodeSet = graph.getNodes();

        maxDepth = 0;
        maxDrop = 0;

        for (Node node : nodeSet) {
            IntPair dfsRet = dfs(node);
            int depth = dfsRet.getFirst();
            int endNodeValue = dfsRet.getSecond();

            if (maxDepth < depth) {
                maxDepth = depth;
                maxDrop = node.getValue() - endNodeValue;
            } else if (maxDepth == depth) {
                maxDrop = Math.max(maxDrop, node.getValue() - endNodeValue);
            }
        }

        return new IntPair(maxDepth, maxDrop);
    }
}

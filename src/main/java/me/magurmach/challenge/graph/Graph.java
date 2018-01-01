package me.magurmach.challenge.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Shakib Ahmed on 1/1/18.
 */
public class Graph {
    HashMap<Node, ArrayList<Node>> adjacentList;

    public Graph() {
        adjacentList = new HashMap<>();
    }

    public void addAdjacency(Node parent, Node children) {
        if (!adjacentList.containsKey(parent)) {
            adjacentList.put(parent, new ArrayList<>());
        }

        adjacentList.get(parent).add(children);
    }

    public ArrayList<Node> getAdjacency(Node node) {
        return adjacentList.get(node);
    }

    public Set<Node> getNodes() {
        return adjacentList.keySet();
    }
}

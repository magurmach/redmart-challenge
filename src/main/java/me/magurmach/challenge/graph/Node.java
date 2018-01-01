package me.magurmach.challenge.graph;

import me.magurmach.challenge.util.Hasher;

/**
 * Created by Shakib Ahmed on 1/1/18.
 */
public class Node {
    private int x, y;

    private int value;

    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Hasher.MAXIMUM_WIDTH * x + y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

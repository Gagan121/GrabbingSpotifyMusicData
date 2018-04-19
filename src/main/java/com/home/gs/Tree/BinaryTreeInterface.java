package com.home.gs.Tree;

import java.util.List;

public interface BinaryTreeInterface<T extends Comparable<T>> {
    void addNode(T element);
    List<T> getSortedTreeAsc();
    List<T> getSortedTreeDesc();

}

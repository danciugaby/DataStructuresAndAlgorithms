package SDA_Laborator_4;

import java.util.*;

public class Tree {
    LinkedList<MyNode> tree;
    void Insert(MyNode node)
    {
        if (tree==null)
        {
            tree = new LinkedList<MyNode>();
            tree.add(node);
            return;
        }

        MyNode nod = GetLastNode();
        if (nod.child_left==null) {
            nod.child_left = node;
            node.parent = nod;
        }
        else
        {
            nod.child_right = node;
            node.parent = nod;
        }
        tree.add(node);
    }

    MyNode GetLastNode() {
        int index=0;
        MyNode node = tree.get(index);
        //parcurgere BFS
        while (node.child_left!=null && node.child_right!=null)
        {
          node = tree.get(++index);
        }
        return node;
    }
}

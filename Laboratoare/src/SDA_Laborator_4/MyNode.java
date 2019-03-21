package SDA_Laborator_4;

public class MyNode {
    MyNode parent;
    MyNode child_left;
    MyNode child_right;
    int val;

    public MyNode(MyNode parent, MyNode child_left, MyNode child_right, int val) {
        this.parent = parent;
        this.child_left = child_left;
        this.child_right = child_right;
        this.val = val;
    }
    public MyNode(int val) {
        this.parent = null;
        this.child_left = null;
        this.child_right = null;
        this.val = val;
    }
}

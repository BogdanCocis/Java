package isp.lab3.exercise1;

public class Tree {
    private int heightOfTree;


    public Tree(int heightOfTree) {
        this.heightOfTree = heightOfTree;
    }

    public int getHeightOfTree() {
        return heightOfTree;
    }

    public void growTree(int meters) {
        if (meters >= 1) {
            heightOfTree += meters;
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "heightOfTree = " + heightOfTree +
                '}';
    }
}

import java.util.function.Consumer;

abstract class Node {
    Strategy orderStrategy;
    Student studentObj;
    Node leftChild, rightChild;

    Node(Strategy orderStrategy) {
        this.orderStrategy = orderStrategy;
        this.studentObj = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    Node(Strategy orderStrategy, Student studentObj) {
        this.studentObj = studentObj;
        this.orderStrategy = orderStrategy;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void forEach(Consumer<Node> action) {
        action.accept(this);
        this.leftChild.forEach(leftNode -> {
            System.out.println(leftNode.studentObj.firstName);
        });
        this.rightChild.forEach(rightNode -> {
            System.out.println(rightNode.studentObj.firstName);
        });
    }

    public abstract boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull);

    public abstract boolean isNull();

    public abstract void accept(Visitor treeVisitor, int depthCount);

    public abstract boolean search(Node node, Student student);

    public abstract boolean search(Student student);
}

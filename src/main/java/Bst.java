import java.util.function.Consumer;

class Bst{
    int depthNodeCount = 0;
    private RealNode root;

    Bst(Strategy orderStrategy) {
        root = new RealNode(orderStrategy);
    }

    public Node getRoot() {
        return root;
    }

    public boolean addStudent(Student studentObj) {
        if (studentObj.firstName == null || studentObj.redId == 0) {
            System.out.println("Student firstName cannot be null and should have unique Red ID");
            return false;
        }
        return root.add(studentObj);
    }

    public Boolean searchStudent(Student s) {
        if (root.search(s)) {
            return true;
        } else {
            return false;
        }
    }

    void visitTree(Visitor treeVisitor) {
        Node headNode = root;
        visit(headNode, treeVisitor);
    }

    // initial level depthNodeCount is passed
    private void visit(Node headNode, Visitor treeVisitor) {
        headNode.accept(treeVisitor,depthNodeCount);
    }

    public void iterator() {
        this.forEach(node -> {
                    System.out.println(node.studentObj.firstName);
                }
        );
    }

    private void forEach(Consumer<Node> action) {
        action.accept(root);
        this.root.leftChild.forEach(leftNode -> { System.out.println(leftNode.studentObj.firstName);});
        this.root.rightChild.forEach(rightNode -> { System.out.println(rightNode.studentObj.firstName);});
    }
}
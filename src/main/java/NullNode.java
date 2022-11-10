import java.util.function.Consumer;

class NullNode extends Node{

    NullNode(Strategy orderStrategy){
        super(orderStrategy);
    }

     /* in case when current node's left or right child is null, this method is used for
     creating new node*/
    @Override
    public boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull ) {
        return orderStrategy.add(node,studentObj,isRightNodeNull);
    }

    // polymorphic behavior with search of real node
    @Override
    public boolean search(Node node, Student student) {
        return false;
    }

    @Override
    public boolean search(Student student) {
        return false;
    }

    @Override
    public boolean isNull() { return true; }

    @Override
    public void accept(Visitor treeVisitor, int depthNodeCount) {
        treeVisitor.visitBstNullNode(this);
    }

    public void forEach(Consumer<Node> action) {
        // do nothing to indicate end of path
    }
}
class RealNode extends Node{

    RealNode(Strategy orderStrategy) {
        super(orderStrategy);
        setNullNode(this);
    }

    RealNode(Strategy orderStrategy, Student studentObj){
        super(orderStrategy,studentObj);
        setNullNode(this);
    }

    private void setNullNode(RealNode node) {
        NullNode leftChild = new NullNode(orderStrategy);
        NullNode rightChild = new NullNode(orderStrategy);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
    }

    public boolean add(Student student) {
        if(this.studentObj == null){
            this.studentObj = student;
            return true;
        }
        else
            return orderStrategy.add(this, student);
    }


    /* in case of "real" existing node, this method is used for iterating to left or right nulls of
    current node*/
    @Override
    public boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull) {
        return orderStrategy.add(this,studentObj);
    }

    // new realnode creation by passing current node as reference
    public boolean addNewNode(RealNode node, Student studentObj, Boolean isRightNodeNull) {
        RealNode newNode = new RealNode(node.orderStrategy,studentObj);
        if(isRightNodeNull){
            node.rightChild = newNode;
        }
        else{
            node.leftChild = newNode;
        }
        return true;
    }

    /* this method is used for iterating to left or right nulls of
    current node*/
    @Override
    public boolean search(Node node, Student student) {
        return orderStrategy.search(this,student);
    }

    @Override
    public boolean search(Student student) {
        return orderStrategy.search(this, student);
    }

    @Override
    public boolean isNull()
    {
        return false;
    }

    @Override
    public void accept(Visitor treeVisitor,int depthNodeCount) {
        depthNodeCount = treeVisitor.visitBstRealNode(this,depthNodeCount);
        this.leftChild.accept(treeVisitor,depthNodeCount);
        this.rightChild.accept(treeVisitor,depthNodeCount);
    }
}
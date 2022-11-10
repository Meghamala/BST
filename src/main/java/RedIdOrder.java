class RedIdOrder implements Strategy{

    int nodeRedIDComparedValue;

    @Override
    public boolean add(RealNode node, Student studentObj) {
        nodeRedIDComparedValue = compare(studentObj.redId, node.studentObj.redId);

        if(nodeRedIDComparedValue < 0){
            return node.leftChild.add(node, studentObj, false);
        }
        else if(nodeRedIDComparedValue > 0) {
            return node.rightChild.add(node, studentObj, true);
        }
        else
            return false;
    }

    // real node's method is called to create new node for student
    @Override
    public boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull) {
        return node.addNewNode(node,studentObj,isRightNodeNull);
    }

    @Override
    public boolean search(Node node, Student student) {
        nodeRedIDComparedValue = compare(student.redId, node.studentObj.redId);

        if(nodeRedIDComparedValue == 0){
            return true;
        }
        if (nodeRedIDComparedValue < 0) {
            return node.leftChild.search(node, student);
        }
        else
            return node.rightChild.search(node, student);

    }

    private int compare(int studentToAddRedId, int nodeRedID) {
        return studentToAddRedId - nodeRedID;
    }
}
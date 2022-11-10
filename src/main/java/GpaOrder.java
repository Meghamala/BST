class GpaOrder implements Strategy{

    double nodeGpaComparedValue;
    int nodeRedIDComparedValue;

    @Override
    public boolean add(RealNode node, Student studentObj) {
        nodeGpaComparedValue = compare(studentObj.gpa,node.studentObj.gpa) ;

        if (nodeGpaComparedValue < 0) {
            return node.leftChild.add(node, studentObj, false);
        }
        else if (nodeGpaComparedValue > 0) {
            return node.rightChild.add(node, studentObj, true);
        }
        else {
            nodeRedIDComparedValue = compare(studentObj.redId, node.studentObj.redId);

            if(nodeRedIDComparedValue < 0){
                return node.leftChild.add(node, studentObj, false);
            }
            else if(nodeRedIDComparedValue > 0) {
                return node.rightChild.add(node, studentObj, true);
            }
            return false;
        }
    }

    // real node's method is called to create new node for student
    @Override
    public boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull) {
        return node.addNewNode(node,studentObj,isRightNodeNull);
    }

    @Override
    public boolean search(Node node, Student student) {
        nodeGpaComparedValue = compare(student.gpa,node.studentObj.gpa);

        if(nodeGpaComparedValue == 0){
            return true;
        }
        if (nodeGpaComparedValue < 0) {
            return node.leftChild.search(node, student);
        }
        else if (nodeGpaComparedValue > 0) {
            return node.rightChild.search(node, student);
        }
        else
            return false;
    }

    private double compare(double studentToAddGpa, double nodeGpa) {
        return studentToAddGpa - nodeGpa;
    }
    private int compare(int studentToAddRedId, int nodeRedID) {
        return studentToAddRedId - nodeRedID;
    }
}
class LastNameOrder implements Strategy {

    int nodeLastNameComparedValue ;
    int nodeFirstNameComparedValue;

    @Override
    public boolean add(RealNode node, Student studentObj) {
        nodeLastNameComparedValue = compare(studentObj.lastName, node.studentObj.lastName);

        if (nodeLastNameComparedValue < 0) {
            return node.leftChild.add(node, studentObj, false);
        } else if (nodeLastNameComparedValue > 0) {
            return node.rightChild.add(node, studentObj, true);
        } else {
            nodeFirstNameComparedValue = compare(studentObj.firstName, node.studentObj.firstName);

            if (nodeFirstNameComparedValue < 0) {
                return node.leftChild.add(node, studentObj, false);
            } else if (nodeFirstNameComparedValue > 0) {
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
        nodeLastNameComparedValue = compare(student.lastName,node.studentObj.lastName);

        if(nodeLastNameComparedValue == 0){
            return true;
        }
        if (nodeLastNameComparedValue < 0) {
            return node.leftChild.search(node, student);
        }
        else {
            return node.rightChild.search(node, student);
        }
    }

    private int compare(String studentName, String nodeName) {
        return studentName.compareToIgnoreCase(nodeName);
    }

}
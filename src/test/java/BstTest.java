import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BstTest{

        private Bst studentTree, singleStudentTree;
        private List<Student> studentArrayList;

        @Before
        public void setUp() throws Exception{
            studentArrayList = new ArrayList<>();

            Student student1 = new Student("john", "lever", 911, 3.56688);
            Student student2 = new Student("monica", "gellar", 1122, 3.6779);
            Student student3 = new Student("ross", "gellar", 133, 3.419);
            Student student4 = new Student("chandler", "bing", 1044, 3.899);
            Student student5 = new Student("gunther", "tyson", 1555, 3.299);
            Student student6 = new Student("carol", "peterson", 1444, 3.30);

            studentArrayList.add(student1);
            studentArrayList.add(student2);
            studentArrayList.add(student3);
            studentArrayList.add(student4);
            studentArrayList.add(student5);
            studentArrayList.add(student6);
        }

    @Test
    @DisplayName("RedID strategy one node test")
    void addSingleNodeTestForRedIDStrategy() throws Exception {
        // test single input
        singleStudentTree = new Bst(new RedIdOrder());
        Student student1 = new Student("rachel", "green", 101, 3.56688);
        singleStudentTree.addStudent(student1);
        assertEquals("rachel",singleStudentTree.getRoot().studentObj.firstName);

        // visitors for counting null nodes, longest path length and avg path length

        Visitor treeVisitor = new TreeNodeVisitor();
        singleStudentTree.visitTree(treeVisitor);
        assertEquals(2,treeVisitor.totalNullCount());
        assertEquals(0,treeVisitor.longestPathLength());
        assertEquals(0, treeVisitor.avgPathLength());

    }

    @Test
    @DisplayName("RedID strategy insertion,search,visit")
    void addTestForRedIDStrategy() throws Exception {
        setUp();
        studentTree = new Bst(new RedIdOrder());
        for (Student s: studentArrayList) {
            studentTree.addStudent(s);
        }

        Node root = studentTree.getRoot();

        assertEquals("john",root.studentObj.firstName);
        assertEquals("monica",root.rightChild.studentObj.firstName);
        assertEquals("ross",root.leftChild.studentObj.firstName);
        assertEquals("chandler",root.rightChild.leftChild.studentObj.firstName);
        assertEquals("gunther",root.rightChild.rightChild.studentObj.firstName);
        assertEquals("carol",root.rightChild.rightChild.leftChild.studentObj.firstName);

        //search for a student by Red ID

        assertEquals(false,studentTree.searchStudent( new Student(1144)));
        assertEquals(true,studentTree.searchStudent(new Student(1044)));

        // visitors for counting null nodes, longest path length and avg path length

        Visitor treeVisitor = new TreeNodeVisitor();
        studentTree.visitTree(treeVisitor);
        assertEquals(7,treeVisitor.totalNullCount());
        assertEquals(3,treeVisitor.longestPathLength());
        assertEquals(1.67, treeVisitor.avgPathLength());

        // ForEach iterator for printing student names in preorder
        studentTree.iterator();

    }

    @Test
    @DisplayName("LastName strategy insertion,search,visit")
    void addTestForLastNameStrategy() throws Exception {
        setUp();
        studentTree = new Bst(new LastNameOrder());
        for (Student s: studentArrayList) {
            studentTree.addStudent(s);
        }
        Node root = studentTree.getRoot();

        assertEquals("john",root.studentObj.firstName);
        assertEquals("monica",root.leftChild.studentObj.firstName);
        assertEquals("ross",root.leftChild.rightChild.studentObj.firstName);
        assertEquals("chandler",root.leftChild.leftChild.studentObj.firstName);
        assertEquals("gunther",root.rightChild.studentObj.firstName);
        assertEquals("carol",root.rightChild.leftChild.studentObj.firstName);

        //search for a student by Lastname

        assertEquals(false,studentTree.searchStudent( new Student("joshi")));
        assertEquals(true,studentTree.searchStudent(new Student("Lever")));

        // visitors for counting null nodes, longest path length and avg path length

        Visitor treeVisitor = new TreeNodeVisitor();
        studentTree.visitTree(treeVisitor);
        assertEquals(7,treeVisitor.totalNullCount());
        assertEquals(2,treeVisitor.longestPathLength());
        assertEquals(1.67, treeVisitor.avgPathLength());

        // ForEach iterator for printing student names in preorder
        studentTree.iterator();

    }

    @Test
    @DisplayName("Gpa strategy insertion,search,visit")
    void addTestForGpaStrategy() throws Exception {
        setUp();
        studentTree = new Bst(new GpaOrder());
        for (Student s: studentArrayList) {
            studentTree.addStudent(s);
        }
        Node root = studentTree.getRoot();

        assertEquals("john",root.studentObj.firstName);
        assertEquals("monica",root.rightChild.studentObj.firstName);
        assertEquals("ross",root.leftChild.studentObj.firstName);
        assertEquals("chandler",root.rightChild.rightChild.studentObj.firstName);
        assertEquals("gunther",root.leftChild.leftChild.studentObj.firstName);
        assertEquals("carol",root.leftChild.leftChild.leftChild.studentObj.firstName);

        //search for a student by Gpa

        assertEquals(true,studentTree.searchStudent( new Student(3.30)));
        assertEquals(false,studentTree.searchStudent(new Student(3.55)));

        // visitors for counting null nodes, longest path length and avg path length

        Visitor treeVisitor = new TreeNodeVisitor();
        studentTree.visitTree(treeVisitor);
        assertEquals(7,treeVisitor.totalNullCount());
        assertEquals(3,treeVisitor.longestPathLength());
        assertEquals(2.5, treeVisitor.avgPathLength());

        // ForEach iterator for printing student names in preorder
        studentTree.iterator();

    }
}
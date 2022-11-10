public interface Strategy{
    boolean add(RealNode node, Student studentObj);
    boolean add(RealNode node, Student studentObj, Boolean isRightNodeNull);
    boolean search(Node node, Student student);
}
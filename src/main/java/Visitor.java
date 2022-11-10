interface Visitor{
    int visitBstRealNode(Node realNode, int depthNodeCount);
    void visitBstNullNode(NullNode nullNode);
    int longestPathLength();
    int totalNullCount();
    double avgPathLength();
}
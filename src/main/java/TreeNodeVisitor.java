class TreeNodeVisitor implements Visitor{

    int countNullNodes, countRealNodes, initialPathCount, longestPathLength = 0 ;
    int traversedPathCount = 1;
    float avgPathLength = 0;

    /*
    # depthNodeCount keeps track of nodes traversed over a path,
    when a new path is diverged from current node, traversedPathCount
    is incremented which stores total paths
    # depthNodeCount < initialPathCount is true when a new path is
    being traversed
    */
    @Override
    public int visitBstRealNode(Node node, int depthNodeCount) {
        if (depthNodeCount < initialPathCount) {
            traversedPathCount++;
        }
        depthNodeCount++;
        initialPathCount = depthNodeCount;
        countRealNodes++;
        avgPathLength = (float)(countRealNodes - 1) / traversedPathCount;

        if(depthNodeCount > longestPathLength)
            longestPathLength = depthNodeCount-1;
        return depthNodeCount;
    }

    @Override
    public void visitBstNullNode(NullNode node) {
        countNullNodes++;
    }

    @Override
    public int longestPathLength() {
        return longestPathLength;
    }

    @Override
    public int totalNullCount() {
        return countNullNodes;
    }

    @Override
    public double avgPathLength() {
        return Math.round(avgPathLength*100.0)/100.0;
    }
}
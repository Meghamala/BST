# BST
Binary Search Tree implementation with design patterns

Design patterns being used: 
1. Strategy
2. Null Object
3. Visitor
4. Internal Iterator

BST contains Student objects and the tree is ordered based on multiple strategies as defined below:
1. Red ID based order
2. Lastname based order 
3. GPA based order

Null object pattern is used to eliminate usage of Null value checks while ordering and accessing tree elements

Visitor pattern is used to add additional functionalities on tree objects i.e, count number of null nodes in tree and compute longest path and average path length in tree

Iterator ( ForEach ) is used to iterate through tree objects which accepts lambda expression for evaluation

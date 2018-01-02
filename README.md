# Problem Description:

Given a grid on n*m dimension, where each grid cell represents
the height of a particular coordinate, find out the maximum 
length path with the deepest drop where a valid movement is
defined by descendence to all four direction cells:

# Solution description:

We form Graph from the grid. The graph is created by putting
an edge between two adjacent cell where the direction of the
edge is from the cell with bigger value to smaller value and also, they share an edge.

So, we can see, the graph will be a simple DAG and then the problem
becomes simply a problem of finding the longest path in the graph
where tie between the paths is resolved by the difference between
the topmost and down most node value.

# How to run

This is a maven java project. So, having maven installed with java8
is enough to run the problem.

To compile:
```
mvn clean install
```
After compiling, to run:
```
java -jar target/redmart-challenge-1.0-SNAPSHOT-jar-with-dependencies.jar
```

By default, the program process inputs from a file `test.txt`. However,
this is configurable with command line argument.

### Command line arguments

In this program, we have support for command line argument.

`-i` : Input the name of the input file.

Sample:

```$xslt
java -jar target/redmart-challenge-1.0-SNAPSHOT-jar-with-dependencies.jar -i test-2.txt
```
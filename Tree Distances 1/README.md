# Tree Distances I

**Source:** [CSES Problem Set — Tree Distances I](https://cses.fi/problemset/task/1132)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

For every node of a tree, find the distance to the farthest node.

## Approach

- The farthest node from any vertex is one of the two endpoints of a diameter. Find the endpoints with two DFS passes, compute distances from both, and take the maximum per node.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Tree Diameter, DFS

## Files

- [`src/TD1.java`](src/TD1.java)

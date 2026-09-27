# Tree Distances II

**Source:** [CSES Problem Set — Tree Distances II](https://cses.fi/problemset/task/1133)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

For every node of a tree, find the sum of distances to all other nodes.

## Approach

- Rerooting: one DFS computes subtree sizes and the answer for the root (the sum of depths).
- Moving the root from a parent to child c changes the sum by n − 2·size(c), so a second DFS fills in every answer.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Rerooting DP, Subtree Sizes

## Files

- [`src/TD2.java`](src/TD2.java)

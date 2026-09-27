# Message Route

**Source:** [CSES Problem Set — Message Route](https://cses.fi/problemset/task/1667)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Find a shortest path of computers from 1 to n in an undirected network and print it, or IMPOSSIBLE.

## Approach

- BFS from computer 1 storing parents, then walk back from n to rebuild the path.

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m)

## Concepts

BFS, Path Reconstruction

## Files

- [`src/MR.java`](src/MR.java)

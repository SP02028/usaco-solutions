# Count Descendants

**Source:** [AtCoder ABC202 E — Count Descendants](https://atcoder.jp/contests/abc202/tasks/abc202_e)  
**Verified:** ⚪ Not verified automatically: test data was not downloaded for this problem.

## Problem

A rooted tree with N vertices; each query (U, D) asks how many vertices at depth D are in U's subtree.

## Approach

- One DFS assigns Euler-tour entry/exit times and records the entry times of the vertices at each depth (already sorted).
- A vertex at depth D is in U's subtree iff its entry time lies in [in[U], out[U]], so each query takes two binary searches in the depth-D list.

## Complexity

- **Time:** O(N + Q log N)
- **Space:** O(N)

## Concepts

Euler Tour, Binary Search, Trees

## Files

- [`src/CD.java`](src/CD.java)

# Cover it!

**Source:** [Codeforces 1176E — Cover it!](https://codeforces.com/contest/1176/problem/E)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

In a connected undirected graph with n vertices, choose at most floor(n/2) vertices so that every unchosen vertex is adjacent to a chosen one.

## Approach

- Two-colour the graph using a DFS spanning structure (colour alternates between parent and child).
- Every vertex has a neighbour of the other colour, so either colour class is a valid answer; print the smaller one (≤ n/2).

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m)

## Concepts

DFS, Graph Colouring, Spanning Tree

## Files

- [`src/CI.java`](src/CI.java)

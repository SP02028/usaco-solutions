# Mahmoud and Ehab and the bipartiteness

**Source:** [Codeforces 862B — Mahmoud and Ehab and the bipartiteness](https://codeforces.com/contest/862/problem/B)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 7 official Codeforces tests that are published in full.

## Problem

Given a tree with n vertices, find the maximum number of edges that can be added so that the graph stays bipartite and simple.

## Approach

- Two-colour the tree with DFS (a tree is always bipartite).
- A bipartite graph with parts of sizes r and b has at most r·b edges; subtracting the existing n − 1 edges gives (r − 1)(b − 1).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Trees, Bipartite Graphs, DFS

## Files

- [`Bipartiteness.java`](Bipartiteness.java)
- [`src/B.java`](src/B.java)

## Notes

`Bipartiteness.java` is a commented copy of `src/B.java`.

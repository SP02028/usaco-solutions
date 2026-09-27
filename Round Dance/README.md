# Round Dance

**Source:** [Codeforces 1833E — Round Dance](https://codeforces.com/contest/1833/problem/E)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 7 official Codeforces tests that are published in full.

## Problem

Each person remembers one neighbour in a circular dance. Find the minimum and maximum number of dances (cycles) consistent with this.

## Approach

- Build the undirected graph and find its components. A component is closed if every vertex has degree 2 (already a cycle).
- The maximum is the number of components. The minimum is the number of closed components plus 1 if any open chain exists, since all chains can merge into one circle.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Connected Components, DFS

## Files

- [`src/RD.java`](src/RD.java)

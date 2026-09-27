# Graph Composition

**Source:** [Codeforces 2060E — Graph Composition](https://codeforces.com/contest/2060/problem/E)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Given graphs F and G on the same vertices, add or remove edges of F so that F and G have exactly the same connectivity (u, v connected in F iff connected in G). Minimize the number of operations.

## Approach

- Build a DSU for G. Every edge of F joining different G-components must be removed; the other edges are kept and unioned into a DSU for F.
- Inside each G-component, the F-components must be joined, which needs (number of F-components − 1) new edges.

## Complexity

- **Time:** O((n + m) α(n))
- **Space:** O(n + m)

## Concepts

Disjoint Set Union, Connectivity

## Files

- [`src/GC.java`](src/GC.java)

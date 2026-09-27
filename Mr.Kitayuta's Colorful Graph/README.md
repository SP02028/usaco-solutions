# Mr. Kitayuta's Colorful Graph

**Source:** [Codeforces 505B — Mr. Kitayuta's Colorful Graph](https://codeforces.com/contest/505/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full.

## Problem

An undirected multigraph whose edges have colours. Each query asks how many colours connect u and v using only edges of that colour.

## Approach

- Keep a separate adjacency list per colour. For each query and colour, run a DFS from u within that colour and check whether it reaches v.

## Complexity

- **Time:** O(q · (n + m) · m) in the worst case (small constraints)
- **Space:** O(n · m)

## Concepts

DFS, Graph Connectivity

## Files

- [`src/MKCG.java`](src/MKCG.java)

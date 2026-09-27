# Ski Slope

**Source:** [USACO 2025 US Open Contest, Silver — Problem 3: Ski Slope](https://usaco.org/index.php?page=viewproblem2&cpid=1520)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 17 official USACO test cases.

## Problem

A tree of ski checkpoints where each edge has a difficulty and an enjoyment. For each skier (skill s, can skip at most k ≤ 10 edges harder than s), find the maximum total enjoyment of a path from the root.

## Approach

- DFS from the root, keeping for each skip budget k the (k+1)-th largest difficulty on the path; that is the minimum skill needed to reach the node with k skips.
- Sort queries by skill. For each node and each k, mark the enjoyment at the first query that can reach it, then take prefix maxima over queries.

## Complexity

- **Time:** O(11 · N log N + Q log Q)
- **Space:** O(11 · (N + Q))

## Concepts

DFS, Offline Queries, TreeSet

## Files

- [`src/SS.java`](src/SS.java)

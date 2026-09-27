# MooTube

**Source:** [USACO 2018 January Contest, Silver — Problem 3: MooTube](https://usaco.org/index.php?page=viewproblem2&cpid=788)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A tree of videos with edge relevances, where relevance between two videos is the minimum edge on their path. For each query (K, v), count the videos with relevance ≥ K to v.

## Approach

- For each query, BFS from v using only edges with relevance ≥ K, and count the videos reached.

## Complexity

- **Time:** O(N · Q)
- **Space:** O(N)

## Concepts

BFS, Trees

## Files

- [`src/M.java`](src/M.java)

# Moocast

**Source:** [USACO 2016 December Contest, Gold — Problem 1: Moocast](https://usaco.org/index.php?page=viewproblem2&cpid=669)  
**Difficulty:** Gold  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Gold version: find the minimum X (the squared transmission radius shared by every cow's walkie-talkie) such that every cow can reach every other cow, possibly through relays.

## Approach

- Collect all pairwise squared distances and binary search over the sorted list.
- For a candidate X, build the graph of pairs within X and check with DFS that every cow is reachable from cow 0.

## Complexity

- **Time:** O(N² log N)
- **Space:** O(N²)

## Concepts

Binary Search on Answer, Graph Connectivity, DFS

## Files

- [`src/M.java`](src/M.java)

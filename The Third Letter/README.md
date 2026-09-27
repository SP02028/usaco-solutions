# The Third Letter

**Source:** [Codeforces 1850H — The Third Letter](https://codeforces.com/contest/1850/problem/H)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 16 official Codeforces tests that are published in full.

## Problem

Soldiers in n positions with m constraints "soldier a is d units in front of soldier b". Decide whether all constraints are consistent.

## Approach

- Build a weighted graph with edge a → b of weight d and b → a of weight −d. DFS each component, assigning positions; any edge contradicting an assigned position means NO.

## Complexity

- **Time:** O(n + m) per test case
- **Space:** O(n + m)

## Concepts

Weighted Graphs, DFS, Consistency Checking

## Files

- [`src/TTL.java`](src/TTL.java)

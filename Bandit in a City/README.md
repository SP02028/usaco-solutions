# Bandit in a City

**Source:** [Codeforces 1436D — Bandit in a City](https://codeforces.com/contest/1436/problem/D)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

A rooted tree where each vertex holds a_i citizens. The bandit starts at the root and moves down to a leaf; citizens also move down to minimize the number the bandit catches. Find the number caught with optimal play.

## Approach

- For each subtree, citizens can be spread evenly among its leaves, so the bandit catches at least ceil(subtree sum / number of leaves).
- Compute subtree sums and leaf counts with a post-order DFS; the answer is the maximum of ceil(sum / leaves) over all vertices.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Trees, DFS, Greedy

## Files

- [`src/BiC.java`](src/BiC.java)

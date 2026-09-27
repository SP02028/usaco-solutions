# Johnny and Contribution

**Source:** [Codeforces 1361A — Johnny and Contribution](https://codeforces.com/contest/1361/problem/A)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 17 official Codeforces tests that are published in full.

## Problem

Write blogs on vertices of a graph in some order; each blog gets the smallest topic not used by already-written neighbours. Find an order that gives every vertex its desired topic, or −1.

## Approach

- Writing in increasing order of desired topic is forced. The order is valid iff no two neighbours want the same topic and every vertex with topic t has neighbours covering all topics 1..t−1.
- Check both conditions by counting distinct smaller topics among neighbours with a timestamp array.

## Complexity

- **Time:** O(n log n + m)
- **Space:** O(n + m)

## Concepts

Greedy, Graphs, Sorting

## Files

- [`src/JohnnyContribution.java`](src/JohnnyContribution.java)

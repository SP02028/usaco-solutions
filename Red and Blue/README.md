# Red and Blue

**Source:** [Codeforces 1469B — Red and Blue](https://codeforces.com/contest/1469/problem/B)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Two sequences r and b were interleaved while keeping their orders. Maximize the largest prefix sum of the merged sequence.

## Approach

- The optimum places the best prefix of r and the best prefix of b first, so the answer is max prefix sum of r (≥ 0) plus max prefix sum of b (≥ 0).

## Complexity

- **Time:** O(n + m)
- **Space:** O(n + m)

## Concepts

Prefix Sums, Greedy

## Files

- [`src/RAB.java`](src/RAB.java)

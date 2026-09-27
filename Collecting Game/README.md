# Collecting Game

**Source:** [Codeforces 1904B — Collecting Game](https://codeforces.com/contest/1904/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

For each element a_i, start with score a_i (removing it) and repeatedly remove any element ≤ your current score, adding it to the score. Output the maximum number of additional elements removable for each start.

## Approach

- Sort the values. Starting from sorted index i, you can absorb the prefix up to some index next[i], growing while the prefix sum ≥ the next value.
- If next[i−1] ≥ i, element i reaches the same point as i−1, so next[] and prefix sums can be reused, which makes the total work linear after sorting.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Prefix Sums, Greedy

## Files

- [`src/CG.java`](src/CG.java)

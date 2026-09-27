# Minimize Inversions

**Source:** [Codeforces 1918B — Minimize Inversions](https://codeforces.com/contest/1918/problem/B)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Apply the same swaps to two permutations a and b simultaneously to minimize the total number of inversions in both.

## Approach

- Sort the pairs by a; a becomes sorted (0 inversions) and the total is minimized. Print both arrays in that order.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Greedy

## Files

- [`src/MI.java`](src/MI.java)

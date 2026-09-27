# Permutation Sort

**Source:** [Codeforces 1525B — Permutation Sort](https://codeforces.com/contest/1525/problem/B)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

With operations that rearrange any subarray except the whole array, find the minimum number of operations to sort a permutation.

## Approach

- 0 if already sorted. 1 if a[1] = 1 or a[n] = n. 3 if a[1] = n and a[n] = 1. Otherwise 2.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Case Analysis, Permutations

## Files

- [`src/PS.java`](src/PS.java)

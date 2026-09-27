# Equalize

**Source:** [Codeforces 1928B — Equalize](https://codeforces.com/contest/1928/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Add a permutation of 1..n to the array (element-wise). Maximize how many elements become equal.

## Approach

- Only distinct values can end up equal, and two values x < y can match iff y − x ≤ n − 1.
- Deduplicate and sort, then find the largest window of distinct values with max − min ≤ n − 1 using two pointers.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Two Pointers, Sorting

## Files

- [`src/E.java`](src/E.java)

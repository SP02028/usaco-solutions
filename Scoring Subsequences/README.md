# Scoring Subsequences

**Source:** [Codeforces 1794C — Scoring Subsequences](https://codeforces.com/contest/1794/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

For each prefix of a sorted array, find the maximum-length subsequence achieving the prefix's maximum score, where the score is the product of a_i / i over the chosen elements taken in decreasing order.

## Approach

- The optimal subsequence is always a suffix of the prefix, and its left boundary only moves right, so maintain l with two pointers: advance it while arr[l] < (length of the window).

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Two Pointers, Monotonicity

## Files

- [`src/SS.java`](src/SS.java)

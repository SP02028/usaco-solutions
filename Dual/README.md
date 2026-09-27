# Dual (Easy Version)

**Source:** [Codeforces 1854A1 — Dual (Easy Version)](https://codeforces.com/contest/1854/problem/A1)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

In one operation choose i, j and set a_i := a_i + a_j. Make the array non-decreasing using at most 31 operations and print the operations.

## Approach

- If every element is ≤ 0, build suffix sums from right to left (a_i += a_{i+1}), which makes the array non-decreasing.
- Otherwise double the maximum element until it is large, then sweep left to right adding the current maximum to each element twice, so every element becomes positive and larger than the one before.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive

## Files

- [`src/D.java`](src/D.java)

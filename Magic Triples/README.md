# Magic Triples (Easy Version)

**Source:** [Codeforces 1822G1 — Magic Triples (Easy Version)](https://codeforces.com/contest/1822/problem/G1)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Count ordered index triples (i, j, k), all distinct, such that a_j = a_i · b and a_k = a_j · b for some positive integer b.

## Approach

- b = 1 contributes f(x)·(f(x) − 1)·(f(x) − 2) for every value x.
- For b ≥ 2, iterate over each element x and over b with x·b² ≤ max, adding f(x·b) · f(x·b²).

## Complexity

- **Time:** O(n · √(max / a_i)) per test case
- **Space:** O(max value)

## Concepts

Counting, Frequency Arrays, Math

## Files

- [`src/MT.java`](src/MT.java)

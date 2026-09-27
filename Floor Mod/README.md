# Floor and Mod

**Source:** [Codeforces 1485C — Floor and Mod](https://codeforces.com/contest/1485/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Count pairs (a, b) with 1 ≤ a ≤ x and 1 ≤ b ≤ y such that floor(a / b) = a mod b.

## Approach

- Write a = k·(b + 1) with k = a mod b < b. For each k (k² < x), b ranges from k + 1 to min(y, x/k − 1).
- Sum the size of that range over k up to √x.

## Complexity

- **Time:** O(√x) per test case
- **Space:** O(1)

## Concepts

Number Theory, Math

## Files

- [`src/FM.java`](src/FM.java)

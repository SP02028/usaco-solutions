# Luntik and Subsequences

**Source:** [Codeforces 1582B — Luntik and Subsequences](https://codeforces.com/contest/1582/problem/B)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Count subsequences whose sum equals (total sum − 1).

## Approach

- Such a subsequence omits exactly one 1 and any subset of the 0s, so the answer is count(1) · 2^count(0).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Combinatorics, Counting

## Files

- [`src/LAS.java`](src/LAS.java)

## Notes

The folder name is a misspelling of "Luntik".

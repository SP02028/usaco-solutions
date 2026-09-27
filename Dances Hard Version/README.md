# Dances (Hard Version)

**Source:** [Codeforces 1883G2 — Dances (Hard Version)](https://codeforces.com/contest/1883/problem/G2)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Arrays a and b of length n are given, except that a[0] can be any value from 1 to m. You may delete elements of both, and must end with a[i] < b[i] after sorting. For every value of a[0], compute the minimum deletions and sum them.

## Approach

- For a fixed a[0], the answer is n minus the largest k such that the k smallest a's can be matched below the k largest b's; binary search that k.
- As a[0] grows, the answer changes by at most 1 and only once, so binary search the largest a[0] with the base answer and count the rest as base + 1.

## Complexity

- **Time:** O(n log n · log m) per test case
- **Space:** O(n)

## Concepts

Binary Search, Greedy Matching, Sorting

## Files

- [`src/DHV.java`](src/DHV.java)

# Guess the K-th Zero (Easy version)

**Source:** [Codeforces 1520F1 — Guess the K-th Zero (Easy version)](https://codeforces.com/contest/1520/problem/F1)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ⚪ Not verified automatically: interactive problem.

## Problem

Interactive: a hidden binary array of length n; you may ask for the sum of any range. Find the position of the k-th zero using at most 20 queries.

## Approach

- Binary search on the position: query the sum of [1, mid]. The number of zeros there is mid − sum; move left if it is ≥ k, otherwise right.

## Complexity

- **Time:** O(log n) queries
- **Space:** O(1)

## Concepts

Binary Search, Interactive

## Files

- [`src/GTKZ.java`](src/GTKZ.java)

## Notes

Interactive problem, so it could not be checked against stored test files.

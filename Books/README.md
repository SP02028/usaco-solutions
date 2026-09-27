# Books

**Source:** [Codeforces 279B — Books](https://codeforces.com/contest/279/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 13 official Codeforces tests that are published in full.

## Problem

Given reading times of n books in order and t free minutes, find the maximum number of consecutive books that can be read starting from some book.

## Approach

- Sliding window: extend the right end, and shrink from the left while the window's total time exceeds t. Track the longest window.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Two Pointers, Sliding Window

## Files

- [`src/B.java`](src/B.java)

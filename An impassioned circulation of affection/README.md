# An impassioned circulation of affection

**Source:** [Codeforces 814C — An impassioned circulation of affection](https://codeforces.com/contest/814/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

A garland of n letters; each query (m, c) asks for the longest contiguous segment of letter c you can obtain after repainting at most m letters.

## Approach

- For each query, use a sliding window: extend the right end while the number of letters different from c in the window is ≤ m, record the window length, then shrink from the left.

## Complexity

- **Time:** O(n) per query
- **Space:** O(n)

## Concepts

Two Pointers, Sliding Window

## Files

- [`src/aicoa.java`](src/aicoa.java)

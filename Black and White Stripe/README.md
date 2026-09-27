# Black and White Stripe

**Source:** [Codeforces 1690D — Black and White Stripe](https://codeforces.com/contest/1690/problem/D)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

In a string of 'W' and 'B', find the minimum number of W's to recolour so that some k consecutive cells are all black.

## Approach

- Build a prefix count of W's and take the minimum W count over every window of length k.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Prefix Sums, Sliding Window

## Files

- [`src/BaWS.java`](src/BaWS.java)

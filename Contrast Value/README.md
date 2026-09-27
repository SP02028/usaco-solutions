# Contrast Value

**Source:** [Codeforces 1832C — Contrast Value](https://codeforces.com/contest/1832/problem/C)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

For an array a, find the length of the shortest subsequence b with the same 'contrast' Σ|b_i − b_{i+1}|.

## Approach

- First remove consecutive duplicates.
- Every interior element that lies strictly between its neighbours (inside a monotone run) can be removed; only local extrema and endpoints must stay.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Greedy, Local Extrema

## Files

- [`src/CV.java`](src/CV.java)

# Challenging Cliffs

**Source:** [Codeforces 1537C — Challenging Cliffs](https://codeforces.com/contest/1537/problem/C)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Arrange n mountain heights so that |h_1 − h_n| is minimized, and among those arrangements maximize the number of uphill steps.

## Approach

- Sort the heights and find the adjacent pair with the smallest difference (positions pos−1, pos).
- Output h[pos..n−1] followed by h[0..pos−1]. The ends differ minimally and almost every step goes uphill.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Constructive

## Files

- [`src/CC.java`](src/CC.java)

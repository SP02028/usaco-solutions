# Perform Operations to Maximize Score

**Source:** [Codeforces 1998C — Perform Operations to Maximize Score](https://codeforces.com/contest/1998/problem/C)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Arrays a and b (b binary). At most k times you may increase an a_i with b_i = 1. The score is max over i of a_i + median(a without a_i). Maximize the score.

## Approach

- Sort by a. Case 1: spend all k on the largest a_i that can be increased, and add the median of the rest (which depends only on its position relative to n/2).
- Case 2: keep the largest a fixed and binary search the best achievable median m, spending operations greedily on the largest increasable elements below m.
- Take the better of the two cases.

## Complexity

- **Time:** O(n log n + n log C) per test case
- **Space:** O(n)

## Concepts

Binary Search on Answer, Greedy, Case Analysis

## Files

- [`src/POTMS.java`](src/POTMS.java)

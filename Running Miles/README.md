# Running Miles

**Source:** [Codeforces 1826D — Running Miles](https://codeforces.com/contest/1826/problem/D)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Choose l < i1 < i2 < i3 ≤ r, i.e. the three best sights inside a run from l to r, maximizing b_{i1} + b_{i2} + b_{i3} − (r − l).

## Approach

- Fix the middle sight i. The best left sight maximizes b_j + j (a prefix maximum) and the best right sight maximizes b_k − k (a suffix maximum).
- Take the maximum over i of prefix[i] + b_i + suffix[i].

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Prefix/Suffix Maximum

## Files

- [`src/RM.java`](src/RM.java)

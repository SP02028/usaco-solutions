# Karen and Coffee

**Source:** [Codeforces 816B — Karen and Coffee](https://codeforces.com/contest/816/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

n recipes each recommend a temperature range. Answer q queries: how many integer temperatures in [a, b] are recommended by at least k recipes.

## Approach

- A difference array plus a prefix sum gives the coverage of each temperature; mark temperatures with coverage ≥ k and prefix-sum those marks to answer each query in O(1).

## Complexity

- **Time:** O(n + q + T)
- **Space:** O(T)

## Concepts

Difference Arrays, Prefix Sums

## Files

- [`src/KAC.java`](src/KAC.java)

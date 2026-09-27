# Hills And Valleys

**Source:** [Codeforces 1467B — Hills And Valleys](https://codeforces.com/contest/1467/problem/B)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

The intimidation value is the number of hills and valleys. You may change one element to any value; minimize the intimidation value.

## Approach

- Changing a_i only affects the status of positions i−1, i, i+1, and the best new value is either neighbour a[i−1] or a[i+1].
- For each i, try both values, recompute the three local statuses and keep the minimum.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Greedy, Local Analysis

## Files

- [`src/HaV.java`](src/HaV.java)

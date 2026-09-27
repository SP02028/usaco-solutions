# Differential Sorting

**Source:** [Codeforces 1635C — Differential Sorting](https://codeforces.com/contest/1635/problem/C)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

You may replace a[x] with a[y] − a[z] for x < y < z. Make the array non-decreasing with at most n operations, or print −1.

## Approach

- If the last two elements are decreasing, it is impossible, because they can never change.
- If the array is already sorted, print 0.
- Otherwise it works only when a[n] ≥ 0: set every a[i] (i ≤ n−2) to a[n−1] − a[n], a value ≤ a[n−1].

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Greedy

## Files

- [`src/DS.java`](src/DS.java)

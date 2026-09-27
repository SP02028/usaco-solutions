# Max Median

**Source:** [Codeforces 1486D — Max Median](https://codeforces.com/contest/1486/problem/D)  
**Difficulty:** Codeforces rating 2100  
**Verified:** ✅ Passes all 19 official Codeforces tests that are published in full.

## Problem

Find the maximum median over all subarrays of length at least k.

## Approach

- Binary search on the median m: map elements ≥ m to +1 and the rest to −1. A subarray of length ≥ k has median ≥ m iff its sum is positive.
- Check with prefix sums, tracking the minimum prefix at least k positions back.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Binary Search on Answer, Prefix Sums

## Files

- [`src/MM.java`](src/MM.java)

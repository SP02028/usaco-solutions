# Monoblock

**Source:** [Codeforces 1715C — Monoblock](https://codeforces.com/contest/1715/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

The awesomeness of an array is its number of blocks of equal consecutive elements. Maintain the sum of awesomeness over all subarrays under point updates.

## Approach

- Every subarray contributes 1, plus 1 for each boundary i (a_i ≠ a_{i+1}) it contains, and boundary i lies in i·(n − i) subarrays.
- On an update, subtract the contributions of the two neighbouring boundaries, change the value, and add them back.

## Complexity

- **Time:** O(n + m)
- **Space:** O(n)

## Concepts

Contribution Technique, Counting

## Files

- [`src/M.java`](src/M.java)

# Maximum Median

**Source:** [Codeforces 1201C — Maximum Median](https://codeforces.com/contest/1201/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 30 official Codeforces tests that are published in full.

## Problem

With at most k +1 operations on an array of odd length n, maximize the median.

## Approach

- Sort the array and binary search the target median x: the cost is Σ max(0, x − a_i) over the upper half, and x is feasible if the cost is ≤ k.

## Complexity

- **Time:** O(n log n + n log C)
- **Space:** O(n)

## Concepts

Binary Search on Answer, Sorting, Greedy

## Files

- [`src/MM.java`](src/MM.java)

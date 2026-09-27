# Range Sorting (Easy Version)

**Source:** [Codeforces 1827B1 — Range Sorting (Easy Version)](https://codeforces.com/contest/1827/problem/B1)  
**Difficulty:** Codeforces rating 2000  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

The beauty of an array is the minimum total cost of sorting it with range sorts (sorting [l, r] costs r − l). Sum the beauty over all subarrays.

## Approach

- For each start, extend the end and maintain a stack of block maxima, merging blocks when a smaller element arrives.
- A subarray's beauty is its length minus its number of independent blocks, so accumulate len − blocks.

## Complexity

- **Time:** O(n²) per test case
- **Space:** O(n)

## Concepts

Monotonic Stack, Brute Force over Subarrays

## Files

- [`src/RSEV.java`](src/RSEV.java)

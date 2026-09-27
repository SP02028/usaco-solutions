# Range and Partition

**Source:** [Codeforces 1630B — Range and Partition](https://codeforces.com/contest/1630/problem/B)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Choose a range [x, y] with minimal width and split the array into exactly k subarrays, each having strictly more elements inside [x, y] than outside. Output the range and the split.

## Approach

- A valid split exists iff at least ceil((n + k)/2) elements lie in the range, so slide a window of that size over the sorted array to find the minimal width.
- Then greedily cut a new segment whenever its inside − outside balance becomes positive; the last segment takes the rest.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Sliding Window, Greedy

## Files

- [`src/RaP.java`](src/RaP.java)

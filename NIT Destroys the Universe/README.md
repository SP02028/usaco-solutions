# NIT Destroys the Universe

**Source:** [Codeforces 1696B — NIT Destroys the Universe](https://codeforces.com/contest/1696/problem/B)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

One operation replaces a subarray with its MEX. Find the minimum number of operations to make the whole array zero.

## Approach

- 0 operations if it is already all zeros. 1 if the non-zero elements form one contiguous block (the block contains no 0, so its MEX is 0). Otherwise 2 (first make everything non-zero, then take the MEX of the whole array).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

MEX, Case Analysis

## Files

- [`src/NITDTU.java`](src/NITDTU.java)

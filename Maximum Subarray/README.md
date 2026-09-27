# Maximum Subarray Sum

**Source:** [CSES Problem Set — Maximum Subarray Sum](https://cses.fi/problemset/task/1643)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Find the maximum sum of a non-empty contiguous subarray.

## Approach

- Kadane's algorithm: the best sum ending at i is max(a_i, best ending at i−1 + a_i); track the overall maximum.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Kadane's Algorithm, Dynamic Programming

## Files

- [`src/MS.java`](src/MS.java)

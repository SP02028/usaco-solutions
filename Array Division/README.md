# Array Division

**Source:** [CSES Problem Set — Array Division](https://cses.fi/problemset/task/1085)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Divide an array of n positive integers into k contiguous subarrays so that the maximum subarray sum is as small as possible.

## Approach

- Binary search on the answer M between max(a) and sum(a).
- Check a candidate greedily: extend the current segment while the sum stays ≤ M, otherwise start a new segment, and count whether at most k segments are used.

## Complexity

- **Time:** O(n log(sum))
- **Space:** O(n)

## Concepts

Binary Search on Answer, Greedy

## Files

- [`src/AD.java`](src/AD.java)

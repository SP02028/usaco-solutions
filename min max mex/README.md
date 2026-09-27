# Min Max MEX

**Source:** [Codeforces 2093E — Min Max MEX](https://codeforces.com/contest/2093/problem/E)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

Split an array into k subarrays to maximize the minimum MEX among them.

## Approach

- Binary search on the answer x: greedily cut a new subarray as soon as it contains all of 0..x−1, and check that at least k pieces result.

## Complexity

- **Time:** O(n log n) per test case
- **Space:** O(n)

## Concepts

Binary Search on Answer, Greedy, MEX

## Files

- [`src/MMM.java`](src/MMM.java)

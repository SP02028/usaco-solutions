# DBMB and the Array

**Source:** [Codeforces 2193A — DBMB and the Array](https://codeforces.com/contest/2193/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

Given an array with sum S, decide whether repeatedly adding x to single elements can make the array sum exactly s.

## Approach

- Additions only increase the sum by multiples of x, so the answer is YES iff S ≤ s and (s − S) is divisible by x.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(1)

## Concepts

Math

## Files

- [`src/DBMB.java`](src/DBMB.java)

# Sequence Master

**Source:** [Codeforces 1806C — Sequence Master](https://codeforces.com/contest/1806/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Find the minimum total |a_i − q_i| such that q (length 2n) is 'good': for every subset of n elements, the product of the subset equals the sum of the complement.

## Approach

- Only a few good arrays exist: all zeros; [x, x] when n = 1; all 2's when n = 2; and for even n, one element equal to n with the rest −1.
- Compute the cost to each candidate (using the precomputed sum of |a_i + 1| for the last family) and take the minimum.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Math, Case Analysis

## Files

- [`src/SM.java`](src/SM.java)

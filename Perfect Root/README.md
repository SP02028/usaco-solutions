# Perfect Root

**Source:** [Codeforces 2185A — Perfect Root](https://codeforces.com/contest/2185/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Output format checked against the problem statement (any valid answer is accepted).

## Problem

Output n distinct perfect roots (positive integers x such that some integer y has √y = x) in the range [1, 10⁹].

## Approach

- Every positive integer x is a perfect root (y = x²), so print 1, 2, …, n.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(1)

## Concepts

Observation, Constructive

## Files

- [`src/PR.java`](src/PR.java)

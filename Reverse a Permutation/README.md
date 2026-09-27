# Reverse a Permutation

**Source:** [Codeforces 2193B — Reverse a Permutation](https://codeforces.com/contest/2193/problem/B)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

Reverse exactly one subarray to make the permutation lexicographically largest.

## Approach

- Find the first position where the array is not already n, n−1, …, then reverse from there to the position of the largest remaining value.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Permutations

## Files

- [`src/RaP.java`](src/RaP.java)

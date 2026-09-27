# Minimum LCM

**Source:** [Codeforces 1765M — Minimum LCM](https://codeforces.com/contest/1765/problem/M)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Given n, find positive a, b with a + b = n minimizing lcm(a, b).

## Approach

- Take a = n / p, where p is the smallest prime factor of n, and b = n − a; then b is a multiple of a and lcm(a, b) = b is minimal. If n is prime, use (1, n − 1).

## Complexity

- **Time:** O(√n) per test case
- **Space:** O(1)

## Concepts

Number Theory, Divisors

## Files

- [`src/MLCM.java`](src/MLCM.java)

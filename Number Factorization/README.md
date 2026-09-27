# Number Factorization

**Source:** [Codeforces 1787B — Number Factorization](https://codeforces.com/contest/1787/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Represent n as a product of a_i^{p_i}, where every a_i is a product of distinct primes, maximizing Σ a_i · p_i.

## Approach

- Factorize n. Repeatedly take every prime that still has a positive exponent, let m be the smallest such exponent, add (product of those primes) · m, and subtract m from each exponent.

## Complexity

- **Time:** O(√n) per test case
- **Space:** O(log n)

## Concepts

Prime Factorization, Greedy

## Files

- [`src/NF.java`](src/NF.java)

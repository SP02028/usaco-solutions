# Trailing Loves (or L'oeufs?)

**Source:** [Codeforces 1114C — Trailing Loves (or L'oeufs?)](https://codeforces.com/contest/1114/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Find the number of trailing zeros of n! written in base b.

## Approach

- Factorize b = Π p_i^{e_i}. The exponent of p in n! is Σ floor(n / p^k) (Legendre's formula). The answer is the minimum over primes of that exponent divided by e_i.

## Complexity

- **Time:** O(√b + log n per prime)
- **Space:** O(log b)

## Concepts

Legendre's Formula, Prime Factorization

## Files

- [`src/TrailingLoves.java`](src/TrailingLoves.java)

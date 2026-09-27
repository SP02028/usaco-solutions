# Divide and Equalize

**Source:** [Codeforces 1881D — Divide and Equalize](https://codeforces.com/contest/1881/problem/D)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

You may pick a_i, a_j and a divisor x of a_i, replacing a_i with a_i/x and a_j with a_j·x. Decide whether all elements can be made equal.

## Approach

- The operation moves prime factors between elements, so the multiset of all prime factors is fixed. All elements can be made equal iff each prime's total exponent is divisible by n.
- Factorize every value with a smallest-prime-factor sieve and count exponents.

## Complexity

- **Time:** O(MAX log log MAX + n log A)
- **Space:** O(MAX)

## Concepts

Prime Factorization, Sieve, Number Theory

## Files

- [`src/DivideAndEqualize.java`](src/DivideAndEqualize.java)

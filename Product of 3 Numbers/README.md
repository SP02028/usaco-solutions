# Product of Three Numbers

**Source:** [Codeforces 1294C — Product of Three Numbers](https://codeforces.com/contest/1294/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 9 official Codeforces tests that are published in full.

## Problem

Represent n as a · b · c with distinct integers a, b, c ≥ 2, or report NO.

## Approach

- Take a as the smallest divisor of n, then b as the smallest divisor of n / a different from a. c = n / (a · b) must differ from both and be at least 2.

## Complexity

- **Time:** O(√n) per test case
- **Space:** O(1)

## Concepts

Number Theory, Divisors

## Files

- [`src/Po3N.java`](src/Po3N.java)

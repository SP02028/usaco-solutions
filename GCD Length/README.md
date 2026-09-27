# GCD Length

**Source:** [Codeforces 1511B — GCD Length](https://codeforces.com/contest/1511/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Given a, b, c, output positive integers x and y with a and b digits respectively whose gcd has exactly c digits.

## Approach

- Take x = 10^(a−1) and y = (b − c + 1 ones) followed by (c − 1) zeros.
- The repunit part is coprime with 10, so gcd(x, y) = 10^(c−1), which has exactly c digits.

## Complexity

- **Time:** O(a + b) per test case
- **Space:** O(a + b)

## Concepts

Constructive, GCD

## Files

- [`src/gcdlen.java`](src/gcdlen.java)

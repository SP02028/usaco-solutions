# k-LCM (hard version)

**Source:** [Codeforces 1497C2 — k-LCM (hard version)](https://codeforces.com/contest/1497/problem/C2)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Given n and k, output k positive integers summing to n whose LCM is at most n/2.

## Approach

- Use k − 3 ones, then solve the 3-number case for m = n − k + 3:
- m odd → (m/2, m/2, 1); m divisible by 4 → (m/2, m/4, m/4); otherwise → (m/2 − 1, m/2 − 1, 2).

## Complexity

- **Time:** O(k) per test case
- **Space:** O(1)

## Concepts

Constructive, Number Theory

## Files

- [`src/KLCM.java`](src/KLCM.java)

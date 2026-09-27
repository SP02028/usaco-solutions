# Large Addition

**Source:** [Codeforces 1984B — Large Addition](https://codeforces.com/contest/1984/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 38 official Codeforces tests that are published in full.

## Problem

Decide whether x is the sum of two 'large' numbers with the same number of digits (every digit between 5 and 9).

## Approach

- Adding two large numbers always carries, so the first digit of x must be 1, the last digit cannot be 9, and no middle digit can be 0. Check these digit conditions.

## Complexity

- **Time:** O(digits) per test case
- **Space:** O(1)

## Concepts

Math, Digits

## Files

- [`src/LAD.java`](src/LAD.java)

# Factorial Divisibility

**Source:** [Codeforces 1753B — Factorial Divisibility](https://codeforces.com/contest/1753/problem/B)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 14 official Codeforces tests that are published in full.

## Problem

Given a_1..a_n ≤ x, decide whether a_1! + a_2! + … + a_n! is divisible by x!.

## Approach

- Count occurrences of each factorial. Since (i+1) copies of i! make one (i+1)!, carry cnt[i] / (i+1) up to i+1 and keep the remainder.
- The sum is divisible by x! iff every remainder below x is 0.

## Complexity

- **Time:** O(n + x)
- **Space:** O(x)

## Concepts

Math, Carrying

## Files

- [`src/FD.java`](src/FD.java)

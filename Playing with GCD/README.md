# Playing with GCD

**Source:** [Codeforces 1736B — Playing with GCD](https://codeforces.com/contest/1736/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

Decide whether an array b of length n + 1 exists with a_i = gcd(b_i, b_{i+1}).

## Approach

- The minimal choice is b_i = lcm(a_{i−1}, a_i) (with a_0 = a_{n+1} = 1). Build it and check that gcd(b_i, b_{i+1}) reproduces every a_i.

## Complexity

- **Time:** O(n log A)
- **Space:** O(n)

## Concepts

GCD, LCM

## Files

- [`src/gcd.java`](src/gcd.java)

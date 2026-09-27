# Powered Addition

**Source:** [Codeforces 1338A — Powered Addition](https://codeforces.com/contest/1338/problem/A)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

In the x-th second you may add 2^(x−1) to any subset of elements. Find the minimum number of seconds to make the array non-decreasing.

## Approach

- Track the running maximum; the largest drop below it (max − a_i) is the amount some element must be raised.
- Any amount below 2^T can be formed in T seconds, so the answer is the number of bits of the largest drop.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Bit Manipulation, Greedy

## Files

- [`src/PA.java`](src/PA.java)

# XOR Specia-LIS-t

**Source:** [Codeforces 1604B — XOR Specia-LIS-t](https://codeforces.com/contest/1604/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Decide whether an array can be split into subarrays whose LIS lengths have XOR 0.

## Approach

- If n is even, split into single elements (n ones XOR to 0). If n is odd, it works iff the array is not strictly increasing, since some adjacent pair with a[i] ≥ a[i+1] forms a block with LIS 1.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive, Parity, XOR

## Files

- [`src/XORSL.java`](src/XORSL.java)

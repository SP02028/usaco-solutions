# GCD Partition

**Source:** [Codeforces 1780B — GCD Partition](https://codeforces.com/contest/1780/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Split the array into k ≥ 2 contiguous parts to maximize the gcd of the part sums.

## Approach

- Merging parts never lowers the gcd, so two parts are always optimal.
- Try every split point and take the maximum of gcd(prefix sum, suffix sum).

## Complexity

- **Time:** O(n log S)
- **Space:** O(n)

## Concepts

GCD, Prefix Sums

## Files

- [`src/GCDP.java`](src/GCDP.java)

# Kevin and Combination Lock

**Source:** [Codeforces 2048A — Kevin and Combination Lock](https://codeforces.com/contest/2048/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Kevin can remove two consecutive 3's from x, or subtract 33 when x ≥ 33. Decide whether x can reach 0.

## Approach

- Removing "33" from the decimal digits changes x by a multiple of 33, so both operations preserve x mod 33. The answer is YES iff x is divisible by 33.

## Complexity

- **Time:** O(1) per test case
- **Space:** O(1)

## Concepts

Math, Modular Arithmetic

## Files

- [`src/Lock.java`](src/Lock.java)

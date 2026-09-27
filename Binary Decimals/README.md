# Product of Binary Decimals

**Source:** [Codeforces 1950D — Product of Binary Decimals](https://codeforces.com/contest/1950/problem/D)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Decide whether n can be written as a product of 'binary decimals' (numbers whose decimal digits are only 0 and 1).

## Approach

- Precompute all binary decimals up to 100000.
- Greedily divide n by each binary decimal (larger than 1) as many times as possible; n is representable if the leftover value is itself a binary decimal (including 1).

## Complexity

- **Time:** O(32 · log n) per test case
- **Space:** O(1)

## Concepts

Math, Number Theory

## Files

- [`src/BD.java`](src/BD.java)

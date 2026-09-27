# Binary Strings are Fun

**Source:** [Codeforces 1762C — Binary Strings are Fun](https://codeforces.com/contest/1762/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

For every prefix of a binary string, count the extensions (inserting characters between existing ones) in which every original character is the median of its prefix; output the sum modulo 998244353.

## Approach

- For a prefix, only the last run of equal characters matters: if that run has length L, the prefix contributes 2^(L−1) extensions.
- Scan the string tracking the current run length and add 2^(L−1) with fast modular exponentiation.

## Complexity

- **Time:** O(n log n)
- **Space:** O(1)

## Concepts

Combinatorics, Modular Arithmetic

## Files

- [`src/BSAF.java`](src/BSAF.java)

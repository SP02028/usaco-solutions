# Super-Permutation

**Source:** [Codeforces 1822D — Super-Permutation](https://codeforces.com/contest/1822/problem/D)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Find a permutation of 1..n whose prefix sums taken mod n form a permutation of 0..n−1, or print −1.

## Approach

- Impossible for odd n > 1. For even n, alternate n, 1, n−2, 3, n−4, 5, …; the prefix sums then cover every residue exactly once.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive, Modular Arithmetic

## Files

- [`src/SP.java`](src/SP.java)

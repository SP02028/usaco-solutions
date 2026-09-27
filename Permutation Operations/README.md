# Permutation Operations

**Source:** [Codeforces 1746C — Permutation Operations](https://codeforces.com/contest/1746/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 13 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

For i = 1..n you must choose a suffix of a permutation and add i to all of its elements. Choose suffixes to minimize the final number of inversions (0 is always possible).

## Approach

- Apply operation value i to the suffix that starts right after the element with value i (or position n if it is last).
- The element with value v then trails the next element by at least the added amount, which removes every descent.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Constructive, Permutations

## Files

- [`src/PO.java`](src/PO.java)

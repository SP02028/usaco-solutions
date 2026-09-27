# Sequence Pair Weight

**Source:** [Codeforces 1527C — Sequence Pair Weight](https://codeforces.com/contest/1527/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

The weight of a sequence is the number of index pairs i < j with equal values. Sum the weights over all subarrays.

## Approach

- A pair (i, j) of equal values contributes (i + 1)·(n − j) (0-indexed), the number of subarrays containing both.
- Sweeping j, keep for each value the sum of (i + 1) over earlier occurrences, and accumulate the running total.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Contribution Technique, Hashing

## Files

- [`src/SPW.java`](src/SPW.java)

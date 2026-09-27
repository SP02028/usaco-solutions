# Odd/Even Increments

**Source:** [Codeforces 1669C — Odd/Even Increments](https://codeforces.com/contest/1669/problem/C)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

You may add 1 to all odd-indexed elements or to all even-indexed elements, any number of times. Decide whether all elements can be made the same parity.

## Approach

- Elements at even indices always change parity together, and so do elements at odd indices. The answer is YES iff each index class already has a uniform parity.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Parity, Observation

## Files

- [`src/OaEI.java`](src/OaEI.java)

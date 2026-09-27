# Zigzags

**Source:** [Codeforces 1400D — Zigzags](https://codeforces.com/contest/1400/problem/D)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Count quadruples i < j < k < l with a_i = a_k and a_j = a_l.

## Approach

- Fix j and k, moving j leftward from k − 1 while tracking counts of values to the right of k. The pairs formed with a_j = a_l are accumulated and added whenever a_j matches a_k's partner condition.

## Complexity

- **Time:** O(n²) per test case
- **Space:** O(n)

## Concepts

Counting, Prefix Frequencies

## Files

- [`src/Z.java`](src/Z.java)

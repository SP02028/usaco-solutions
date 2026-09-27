# Cobb

**Source:** [Codeforces 1554B — Cobb](https://codeforces.com/contest/1554/problem/B)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Maximize i·j − k·(a_i | a_j) over pairs i < j, where 0 ≤ a_i ≤ n and k is small.

## Approach

- The penalty k·(a_i | a_j) is at most about 2kn, so the optimal pair must have i and j among the last ~2k indices.
- Brute force over all pairs with i ≥ n − 2k.

## Complexity

- **Time:** O(k²) per test case
- **Space:** O(n)

## Concepts

Math, Bounding, Brute Force

## Files

- [`src/C.java`](src/C.java)

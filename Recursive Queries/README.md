# Recursive Queries

**Source:** [Codeforces 932B — Recursive Queries](https://codeforces.com/contest/932/problem/B)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

g(n) repeatedly takes the product of the non-zero digits until a single digit remains. Answer queries counting x in [l, r] with g(x) = k.

## Approach

- Compute g for every number up to r, keep a prefix count per digit 1..9, and answer each query by subtracting prefix counts.

## Complexity

- **Time:** O(r · 9 + q) as written (recomputed per query)
- **Space:** O(10 · r)

## Concepts

Prefix Sums, Digit Manipulation

## Files

- [`src/RQ.java`](src/RQ.java)

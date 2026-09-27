# Count Subrectangles

**Source:** [Codeforces 1323B — Count Subrectangles](https://codeforces.com/contest/1323/problem/B)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

Given binary arrays a (length n) and b (length m), the matrix c_{ij} = a_i · b_j. Count subrectangles of area k consisting only of ones.

## Approach

- Build a 2D prefix sum of c.
- For each divisor pair (l, w) with l·w = k, slide every l×w window and count windows whose sum equals k.

## Complexity

- **Time:** O(d(k) · n · m)
- **Space:** O(n · m)

## Concepts

2D Prefix Sums, Divisors

## Files

- [`src/CS.java`](src/CS.java)

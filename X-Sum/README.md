# X-Sum

**Source:** [Codeforces 1676D — X-Sum](https://codeforces.com/contest/1676/problem/D)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Place a bishop on an n×m board of non-negative numbers to maximize the sum of all cells on its two diagonals.

## Approach

- For every cell, walk the four diagonal directions and sum them, subtracting the extra three counts of the centre cell. Take the maximum.

## Complexity

- **Time:** O(n · m · (n + m))
- **Space:** O(n · m)

## Concepts

Brute Force, Grid

## Files

- [`src/XSUM.java`](src/XSUM.java)

# Vertical Paths

**Source:** [Codeforces 1675D — Vertical Paths](https://codeforces.com/contest/1675/problem/D)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Split a rooted tree into the minimum number of vertical paths (each going strictly downward) covering every vertex exactly once, and print them.

## Approach

- Every leaf must start its own path, and that is enough: from each leaf, climb parents while they are unused, then print the path top-down.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Trees, Greedy

## Files

- [`src/VP.java`](src/VP.java)

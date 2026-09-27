# Power of Points

**Source:** [Codeforces 1857E — Power of Points](https://codeforces.com/contest/1857/problem/E)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

For each point s, compute Σ over all points x of (|x − s| + 1).

## Approach

- Sort the points. Compute the answer for the smallest point directly, then move to each next point: points to the left gain the distance delta and points to the right lose it.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Prefix Sums, Sweep

## Files

- [`src/PoP.java`](src/PoP.java)

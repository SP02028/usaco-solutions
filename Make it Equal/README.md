# Make It Equal

**Source:** [Codeforces 1065C — Make It Equal](https://codeforces.com/contest/1065/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Towers of heights h_i. One slice cuts all towers down to some height H and costs the number of cubes removed, which must be ≤ k. Find the minimum number of slices to make all towers equal.

## Approach

- Count the towers at least as tall as each height with a suffix sum.
- Sweep heights from the maximum down: accumulate the cost of lowering to the next height, and when it would exceed k, count a slice and reset.

## Complexity

- **Time:** O(max height + n)
- **Space:** O(max height)

## Concepts

Suffix Sums, Greedy

## Files

- [`src/MiE.java`](src/MiE.java)

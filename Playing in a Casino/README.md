# Playing in a Casino

**Source:** [Codeforces 1808B — Playing in a Casino](https://codeforces.com/contest/1808/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A card game where each pair of players scores the sum over columns of |c_{i,j} − c_{k,j}|. Output the total over all pairs.

## Approach

- Columns are independent. Sort each column; the element at sorted position k contributes (sum of larger values) − (count of larger values) · value, computed with a running prefix sum.

## Complexity

- **Time:** O(n · m log n)
- **Space:** O(n · m)

## Concepts

Sorting, Prefix Sums, Contribution Technique

## Files

- [`src/GalaxyLuck.java`](src/GalaxyLuck.java)

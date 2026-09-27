# The Party and Sweets

**Source:** [Codeforces 1158A — The Party and Sweets](https://codeforces.com/contest/1158/problem/A)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 15 official Codeforces tests that are published in full.

## Problem

Same problem as `The Party & Sweets`: minimize the total sweets under per-boy minimum and per-girl maximum constraints.

## Approach

- Check max(b) ≤ min(g). The base total is Σb · m + Σg − max(b) · m, adjusted by using the second-largest boy when no girl's g equals max(b).

## Complexity

- **Time:** O(n log n + m)
- **Space:** O(n)

## Concepts

Greedy, Math

## Files

- [`src/TpAS.java`](src/TpAS.java)

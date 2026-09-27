# Coloring

**Source:** [Codeforces 1774B — Coloring](https://codeforces.com/contest/1774/problem/B)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full.

## Problem

Colour n cells with m colours, using colour i exactly a_i times, so that any k consecutive cells have distinct colours. Decide whether it is possible.

## Approach

- Split the cells into blocks of k; each colour can appear at most ceil(n/k) times.
- Only n mod k colours can reach the maximum ceil(n/k) (when k does not divide n), so check both limits.

## Complexity

- **Time:** O(m) per test case
- **Space:** O(m)

## Concepts

Pigeonhole Principle, Math

## Files

- [`src/C.java`](src/C.java)

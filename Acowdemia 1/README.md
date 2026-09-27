# Acowdemia I

**Source:** [USACO 2021 US Open Contest, Bronze — Problem 1: Acowdemia I](https://usaco.org/index.php?page=viewproblem2&cpid=1131)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 17 official USACO test cases.

## Problem

Bessie has N papers with citation counts and may write one survey citing up to L of her papers (each at most once). Maximize the resulting h-index.

## Approach

- Sort in decreasing order and compute the current h-index.
- The best use of the survey is to add one citation to the papers at positions h−L+1 … h (the ones just around the threshold), then recompute the h-index.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Greedy

## Files

- [`src/A1.java`](src/A1.java)

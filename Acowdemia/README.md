# Acowdemia

**Source:** [USACO 2021 US Open Contest, Silver — Problem 3: Acowdemia](https://usaco.org/index.php?page=viewproblem2&cpid=1136)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

Bessie has N papers with citation counts and can write K surveys, each citing up to L distinct papers. Maximize her h-index (largest h such that at least h papers have ≥ h citations).

## Approach

- Sort citations in decreasing order and binary search on h.
- h is achievable if the top h papers need at most K·L extra citations in total, and no single paper needs more than K (each survey can cite a paper at most once).

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Sorting, Greedy

## Files

- [`src/A.java`](src/A.java)

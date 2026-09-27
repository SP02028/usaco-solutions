# Acowdemia II

**Source:** [USACO 2021 US Open Contest, Bronze — Problem 2: Acowdemia II](https://usaco.org/index.php?page=viewproblem2&cpid=1132)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given K publications, each listing the same N members in order of (seniority desc, then alphabetical within equal seniority), determine for every pair of members whether one is known to be more senior ('1'/'0') or unknown ('?').

## Approach

- Within a publication, a new seniority group begins whenever the name order stops being alphabetical.
- For every pair of members in different groups of the same publication, the earlier one is more senior; fill both cells of the result matrix.

## Complexity

- **Time:** O(K · N²)
- **Space:** O(N²)

## Concepts

Simulation, Ordering

## Files

- [`src/A2.java`](src/A2.java)

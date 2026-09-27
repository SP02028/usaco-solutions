# Goldilocks and the N Cows

**Source:** [USACO 2013 November Contest, Bronze — Problem 2: Goldilocks and the N Cows](https://usaco.org/index.php?page=viewproblem2&cpid=341)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N plants each grow best when the water level T lies in [A_i, B_i]: they produce X below the range, Y inside it and Z above it. Choose T to maximize total production.

## Approach

- Only the values A_i and B_i + 1 can change the answer, so evaluate those candidate levels.
- Sort the A's and the B's and count, for a given T, how many plants are below, inside and above their ranges with binary search.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Binary Search, Candidate Points

## Files

- [`src/PG.java`](src/PG.java)

## Notes

This is AlphaStar's reworded version of USACO 2013 November Bronze "Goldilocks and the N Cows"; the folder keeps the AlphaStar title.

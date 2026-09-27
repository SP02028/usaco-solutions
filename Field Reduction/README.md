# Field Reduction

**Source:** [USACO 2016 US Open Contest, Bronze — Problem 3: Field Reduction](https://usaco.org/index.php?page=viewproblem2&cpid=641)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Remove one cow from N cows so that the area of the smallest axis-aligned rectangle enclosing the rest is minimized.

## Approach

- Track the two smallest and two largest x and y coordinates.
- For each cow, if it is an extreme in some direction, replace that extreme with the second-best value, and compute the resulting area.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Geometry, Greedy

## Files

- [`src/fr.java`](src/fr.java)

## Notes

Uses USACO file I/O (`reduce.in` / `reduce.out`).

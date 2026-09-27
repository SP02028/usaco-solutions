# Social Distancing II

**Source:** [USACO 2020 US Open Contest, Bronze — Problem 2: Social Distancing II](https://usaco.org/index.php?page=viewproblem2&cpid=1036)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows at distinct positions are healthy or sick. Infection spreads to cows within an unknown radius R. Find the minimum number of initially infected cows consistent with the observations.

## Approach

- R must be smaller than the smallest gap between a sick and a healthy cow.
- Count clusters of sick cows, adding a new cluster whenever the gap between consecutive sick cows is at least that bound.

## Complexity

- **Time:** O(max coordinate)
- **Space:** O(max coordinate)

## Concepts

Greedy, Sweep

## Files

- [`src/sd2.java`](src/sd2.java)

## Notes

Uses USACO file I/O (`socdist2.in` / `socdist2.out`).

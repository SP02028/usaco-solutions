# Why Did the Cow Cross the Road

**Source:** [USACO 2017 February Contest, Bronze — Problem 1: Why Did the Cow Cross the Road](https://usaco.org/index.php?page=viewproblem2&cpid=711)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given observations (cow ID, side of the road) in time order, count how many times some cow must have crossed the road.

## Approach

- Remember the last observed side of each cow and count every change of side.

## Complexity

- **Time:** O(N)
- **Space:** O(10)

## Concepts

Simulation

## Files

- [`src/WDtCCtR.java`](src/WDtCCtR.java)

## Notes

Uses USACO file I/O (`crossroad.in` / `crossroad.out`).

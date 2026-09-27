# Stuck in a Rut

**Source:** [USACO 2020 December Contest, Bronze — Problem 3: Stuck in a Rut](https://usaco.org/index.php?page=viewproblem2&cpid=1061)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows move north or east one unit per step and stop when they reach grass another cow has already eaten. Output how much each cow eats, or Infinity (Stuck in a Rut, Bronze).

## Approach

- Sort north cows by x and east cows by y. For each north/east pair whose paths cross, compare the distances each travels to the intersection; the cow that arrives later is blocked there, provided the blocking cow was not itself stopped earlier.
- Record the stopping coordinate and print the distances.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Simulation, Sorting

## Files

- [`src/StuckInARut2.java`](src/StuckInARut2.java)

## Notes

The folder name is short for Stuck in a Rut (Bronze).

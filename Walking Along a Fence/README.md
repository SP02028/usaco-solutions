# Walking Along a Fence

**Source:** [USACO 2024 US Open Contest, Bronze — Problem 2: Walking Along a Fence](https://usaco.org/index.php?page=viewproblem2&cpid=1420)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

A closed fence polygon on a grid, and N cows each walking between two points on the fence. For each cow, output the shorter walking distance along the fence.

## Approach

- Walk the whole fence once, labelling every lattice point with its distance from the start.
- For each query, the distance one way is the difference of the labels and the other way is the perimeter minus that; print the minimum.

## Complexity

- **Time:** O(perimeter + N)
- **Space:** O(grid size)

## Concepts

Simulation, Prefix Distances

## Files

- [`src/WAaF.java`](src/WAaF.java)

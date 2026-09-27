# The Lazy Cow

**Source:** [USACO 2014 March Contest, Silver — Problem 2: The Lazy Cow](https://usaco.org/index.php?page=viewproblem2&cpid=416)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Same problem as `TLC3` (stdin version): the maximum grass reachable within K Manhattan steps of any starting cell.

## Approach

- Rotate the grid 45° so Manhattan balls become squares, then use 2D prefix sums to evaluate the square around every cell.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Coordinate Rotation, 2D Prefix Sums

## Files

- [`src/TLC.java`](src/TLC.java)

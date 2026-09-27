# The Lazy Cow

**Source:** [USACO 2014 March Contest, Silver — Problem 2: The Lazy Cow](https://usaco.org/index.php?page=viewproblem2&cpid=416)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A field of grass values and a cow that can move at most K steps (Manhattan distance). Find the maximum total grass within reach of the best starting cell (The Lazy Cow).

## Approach

- Rotate the grid 45° with (i, j) → (i + j, n − i + j − 1), so that Manhattan balls become axis-aligned squares.
- Build a 2D prefix sum on the rotated grid and evaluate the (2K+1)×(2K+1) square around every original cell.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

Coordinate Rotation, 2D Prefix Sums

## Files

- [`TLC3.java`](TLC3.java)

## Notes

The folder name is short for The Lazy Cow. Uses USACO file I/O (`lazy.in` / `lazy.out`).

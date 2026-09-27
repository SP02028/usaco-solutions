# Painting the Barn

**Source:** [USACO 2019 February Contest, Silver — Problem 2: Painting the Barn](https://usaco.org/index.php?page=viewproblem2&cpid=919)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N axis-aligned rectangles of paint are applied to a barn wall. Count the area covered by exactly K coats.

## Approach

- 2D difference array: +1/−1 at the four corners of each rectangle, then row and column prefix sums give the coats per unit cell. Count cells equal to K.

## Complexity

- **Time:** O(N + 1000²)
- **Space:** O(1000²)

## Concepts

2D Difference Arrays, Prefix Sums

## Files

- [`src/PTB.java`](src/PTB.java)

## Notes

Uses USACO file I/O (`paintbarn.in` / `paintbarn.out`).

# Reflection

**Source:** [USACO 2025 February Contest, Bronze — Problem 1: Reflection](https://usaco.org/index.php?page=viewproblem2&cpid=1491)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

An N×N canvas must be symmetric across both axes (made of four mirrored quadrants). Output the minimum number of cells to toggle, initially and after each of U single-cell updates.

## Approach

- Each cell belongs to an orbit of 4 mirror-image cells; that orbit costs min(# '.', # '*').
- Sum the orbit costs initially. For an update, subtract the orbit's old cost, toggle the cell, and add the new cost.

## Complexity

- **Time:** O(N² + U)
- **Space:** O(N²)

## Concepts

Symmetry, Incremental Updates

## Files

- [`src/R.java`](src/R.java)

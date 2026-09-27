# Rectangular Pasture

**Source:** [USACO 2020 December Contest, Silver — Problem 2: Rectangular Pasture](https://usaco.org/index.php?page=viewproblem2&cpid=1063)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

N cows with distinct x and y coordinates. Count the subsets of cows that can be enclosed by some axis-aligned rectangle containing exactly those cows (including the empty set).

## Approach

- Compress coordinates and build a 2D prefix sum of cow positions.
- For each pair of cows as the leftmost and rightmost of the subset, the choices for the bottom boundary (cows below) and the top boundary (cows above) multiply. Add 1 for the empty subset.

## Complexity

- **Time:** O(N²)
- **Space:** O(N²)

## Concepts

2D Prefix Sums, Coordinate Compression, Counting

## Files

- [`src/RectangularPasture.java`](src/RectangularPasture.java)

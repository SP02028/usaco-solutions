# Modern Art

**Source:** [USACO 2017 US Open Contest, Bronze — Problem 3: Modern Art](https://usaco.org/index.php?page=viewproblem2&cpid=737)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Paint colours 1..9 were applied as rectangles in some order, and the final canvas is shown. Count the colours that could have been painted first.

## Approach

- Compute each visible colour's bounding rectangle.
- Any colour appearing inside another colour's rectangle must have been painted later, so it cannot be first. Count the colours never found inside another rectangle.

## Complexity

- **Time:** O(9² · N²)
- **Space:** O(N²)

## Concepts

Bounding Boxes, Complete Search

## Files

- [`src/MA.java`](src/MA.java)

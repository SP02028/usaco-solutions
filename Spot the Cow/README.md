# Where's Bessie?

**Source:** [USACO 2017 US Open Contest, Silver — Problem 3: Where's Bessie?](https://usaco.org/index.php?page=viewproblem2&cpid=740)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

An N×N image of coloured letters. Count the maximal sub-rectangles (not contained in another valid one) that consist of exactly two colours, one forming a single connected region and the other forming two or more regions.

## Approach

- Enumerate every sub-rectangle and test it with flood fill, counting the connected regions per colour and rejecting anything with more than two colours.
- Keep the valid rectangles, then count those not contained in any other valid rectangle.

## Complexity

- **Time:** O(N⁶) for enumeration and testing, plus O(V²) for the maximality check
- **Space:** O(N² + V)

## Concepts

Complete Search, Flood Fill

## Files

- [`src/StC.java`](src/StC.java)

## Notes

This is AlphaStar's reworded version of USACO 2017 US Open Silver "Where's Bessie?"; the folder keeps the AlphaStar title.

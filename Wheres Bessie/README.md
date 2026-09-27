# Where's Bessie?

**Source:** [USACO 2017 US Open Contest, Silver — Problem 3: Where's Bessie?](https://usaco.org/index.php?page=viewproblem2&cpid=740)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Count the maximal rectangles in an N×N image that are 'PCLs': exactly two colours, one forming one connected region and the other forming two or more.

## Approach

- Enumerate every sub-rectangle and test it by flood filling regions and counting regions per colour.
- Keep the PCLs and count those not contained in another PCL.

## Complexity

- **Time:** O(N⁶) plus pairwise containment checks
- **Space:** O(N² + number of PCLs)

## Concepts

Complete Search, Flood Fill

## Files

- [`src/WB.java`](src/WB.java)

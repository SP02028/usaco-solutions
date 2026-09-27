# Painting the Fence

**Source:** [USACO 2013 January Contest, Silver — Problem 1: Painting the Fence](https://usaco.org/index.php?page=viewproblem2&cpid=226)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A painter starts at position 0 and makes N moves (distance and direction L/R), painting each unit segment he passes. Count the total length painted at least K times.

## Approach

- Store a +1 / −1 event at the two ends of every move in a TreeMap (a coordinate-compressed difference array).
- Sweep the keys in order, keeping the running coverage, and add the segment length whenever the coverage is ≥ K.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sweep Line, Difference Array on a TreeMap

## Files

- [`src/PS.java`](src/PS.java)

## Notes

This is AlphaStar's reworded version of USACO 2013 January Silver "Painting the Fence"; the folder keeps the AlphaStar title.

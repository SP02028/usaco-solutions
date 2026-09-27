# Load Balancing

**Source:** [USACO 2016 February Contest, Bronze — Problem 3: Load Balancing](https://usaco.org/index.php?page=viewproblem2&cpid=617)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows at odd coordinates; place a vertical and a horizontal fence at even coordinates to minimize the largest number of cows in any of the four regions.

## Approach

- Only fence positions just left of or below some cow matter; try all such pairs and count each quadrant.

## Complexity

- **Time:** O(N³)
- **Space:** O(N)

## Concepts

Complete Search

## Files

- [`src/LB.java`](src/LB.java)

## Notes

Uses USACO file I/O (`balancing.in` / `balancing.out`).

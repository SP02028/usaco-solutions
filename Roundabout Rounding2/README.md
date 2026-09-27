# Roundabout Rounding

**Source:** [USACO 2024 December Contest, Bronze — Problem 1: Roundabout Rounding](https://usaco.org/index.php?page=viewproblem2&cpid=1443)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

Count x ≤ N for which rounding directly to the nearest power of 10 differs from repeatedly rounding digit by digit (chain rounding).

## Approach

- For d-digit numbers, the ones that differ lie in [44…45, 499…9] (from d fours followed by a 5, up to the value just below 5·10^(d−1)).
- Sum the size of that interval, clipped to N, for every digit length.

## Complexity

- **Time:** O(digits) per test case
- **Space:** O(1)

## Concepts

Math, Digits

## Files

- [`src/RR2.java`](src/RR2.java)

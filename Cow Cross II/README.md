# Why Did the Cow Cross the Road II

**Source:** [USACO 2017 February Contest, Bronze — Problem 2: Why Did the Cow Cross the Road II](https://usaco.org/index.php?page=viewproblem2&cpid=712)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A 52-character string lists where each of 26 cows (letters) enters and exits a circular road. Count pairs of cows whose paths must cross, meaning their entry/exit points interleave.

## Approach

- Record the first and second occurrence of each letter.
- Pairs (i, j) cross exactly when start_i < start_j < end_i < end_j; check all 26² ordered pairs.

## Complexity

- **Time:** O(26²)
- **Space:** O(26)

## Concepts

Intervals, Brute Force

## Files

- [`src/CC2.java`](src/CC2.java)

## Notes

Uses USACO file I/O (`circlecross.in` / `circlecross.out`).

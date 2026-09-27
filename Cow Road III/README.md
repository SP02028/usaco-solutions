# Why Did the Cow Cross the Road III

**Source:** [USACO 2017 February Contest, Bronze — Problem 3: Why Did the Cow Cross the Road III](https://usaco.org/index.php?page=viewproblem2&cpid=713)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows arrive at the farm gate at given times, and each needs a given amount of time to be questioned, one cow at a time. Find the time when the last cow enters the farm.

## Approach

- Sort cows by arrival time and simulate: each cow starts at max(its arrival, the time the previous cow finished).

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Simulation

## Files

- [`src/cross.java`](src/cross.java)

## Notes

Uses USACO file I/O (`cowqueue.in` / `cowqueue.out`).

# Taming the Herd

**Source:** [USACO 2018 February Contest, Bronze — Problem 3: Taming the Herd](https://usaco.org/index.php?page=viewproblem2&cpid=809)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A log of 'days since last breakout' counters has some entries missing (−1), and day 1 was a breakout. Find the minimum and maximum possible number of breakouts, or −1 if the log is inconsistent.

## Approach

- Sweep backwards: a known value v forces the previous v days to be v−1, v−2, …, 0. Fill forced entries and detect contradictions.
- Forced zeros are breakouts (minimum); every entry that is still unknown can also be a breakout (maximum).

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Simulation, Constraint Propagation

## Files

- [`src/taming.java`](src/taming.java)

# Speeding Ticket

**Source:** [USACO 2015 December Contest, Bronze — Problem 2: Speeding Ticket](https://usaco.org/index.php?page=viewproblem2&cpid=568)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A 100-mile road is split into segments with speed limits, and Bessie's trip is split into segments with her speeds. Find the maximum amount by which she exceeded the limit.

## Approach

- Expand both segment lists into per-mile arrays of 100 entries and take the maximum of (speed − limit), at least 0.

## Complexity

- **Time:** O(100)
- **Space:** O(100)

## Concepts

Simulation

## Files

- [`src/Main.java`](src/Main.java)

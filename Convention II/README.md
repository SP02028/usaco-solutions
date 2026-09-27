# Convention II

**Source:** [USACO 2018 December Contest, Silver — Problem 2: Convention II](https://usaco.org/index.php?page=viewproblem2&cpid=859)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows arrive at a single pasture (arrival time, eating duration). When the pasture is free, the most senior waiting cow eats. Find the longest time any cow waits.

## Approach

- Sort by arrival time and use a priority queue keyed by seniority.
- Advance a clock; push arrivals and, whenever the pasture is free and the queue is not empty, let the most senior cow eat and record its wait.

## Complexity

- **Time:** O(max time + N log N) (the simulation steps through every time unit)
- **Space:** O(N)

## Concepts

Priority Queue, Simulation

## Files

- [`src/CII.java`](src/CII.java)

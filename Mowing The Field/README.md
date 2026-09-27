# Mowing the Field

**Source:** [USACO 2016 January Contest, Bronze — Problem 3: Mowing the Field](https://usaco.org/index.php?page=viewproblem2&cpid=593)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Farmer John mows along a path of N moves. Find the largest x such that the grass always had at least x time units to regrow before he revisited any cell (the minimum gap between visits), or −1.

## Approach

- Walk step by step, storing the last visit time of each cell in a HashMap; on revisiting, update the answer with the time since the last visit.

## Complexity

- **Time:** O(total steps)
- **Space:** O(total steps)

## Concepts

Simulation, Hashing

## Files

- [`src/MTF.java`](src/MTF.java)

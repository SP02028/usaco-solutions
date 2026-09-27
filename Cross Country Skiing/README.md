# Cross Country Skiing

**Source:** [USACO 2014 January Contest, Silver — Problem 2: Cross Country Skiing](https://usaco.org/index.php?page=viewproblem2&cpid=380)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A grid of elevations contains waypoint cells. Find the minimum D such that all waypoints are mutually reachable by moving between adjacent cells whose elevations differ by at most D.

## Approach

- Binary search on D.
- For a candidate D, flood fill from one waypoint and check that every waypoint was reached.

## Complexity

- **Time:** O(N · M · log H)
- **Space:** O(N · M)

## Concepts

Binary Search on Answer, Flood Fill

## Files

- [`src/CCS.java`](src/CCS.java)

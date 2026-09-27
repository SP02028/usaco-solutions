# Switching on the Lights

**Source:** [USACO 2015 December Contest, Silver — Problem 1: Switching on the Lights](https://usaco.org/index.php?page=viewproblem2&cpid=570)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

In an N×N barn, Bessie starts in the lit room (1,1). Switches in rooms turn on lights in other rooms, and she can only walk through lit rooms. Maximize the number of lit rooms.

## Approach

- BFS over rooms Bessie can reach. When she enters a room, flip all its switches.
- A newly lit room becomes reachable immediately if it is adjacent to an already visited room, and a visited room's lit neighbours are enqueued too. Count all lit rooms at the end.

## Complexity

- **Time:** O(N² + M)
- **Space:** O(N² + M)

## Concepts

BFS, Grid, Simulation

## Files

- [`src/SOL.java`](src/SOL.java)

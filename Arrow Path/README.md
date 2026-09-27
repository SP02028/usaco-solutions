# Arrow Path

**Source:** [Codeforces 1948C — Arrow Path](https://codeforces.com/contest/1948/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A 2×n grid where every cell contains an arrow '<' or '>'. From the current cell you move to a neighbour and then must follow that cell's arrow. Decide whether the robot can reach the bottom-right cell from the top-left.

## Approach

- Model each state as the cell reached after following an arrow and search the reachable states with DFS: from a cell try each of the 4 neighbours, then apply that neighbour's arrow.
- Answer YES if cell (1, n−1) becomes reachable.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Graph Search, DFS, Grid

## Files

- [`src/AP.java`](src/AP.java)

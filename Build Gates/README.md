# Build Gates

**Source:** [USACO 2016 January Contest, Silver — Problem 3: Build Gates](https://usaco.org/index.php?page=viewproblem2&cpid=596)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Farmer John walks a path of N unit moves (N/E/S/W) and builds a fence along it. Find the minimum number of gates needed so all regions of the plane are connected.

## Approach

- Double every coordinate so fence segments occupy grid cells and gaps between them remain visible.
- Mark fenced cells, pad the bounding box by one cell, and count connected regions of free cells with BFS. The answer is (number of regions) − 1.

## Complexity

- **Time:** O(area of the bounding box)
- **Space:** O(area)

## Concepts

Flood Fill, BFS, Coordinate Scaling

## Files

- [`src/BG.java`](src/BG.java)

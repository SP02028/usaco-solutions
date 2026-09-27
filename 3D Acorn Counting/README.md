# 3D Acorn Counting

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

An N×N×N grid (N ≤ 100) is given as N² rows of characters where '*' marks an acorn cell. Count the number of connected groups of acorn cells, where cells are connected through any of their 6 face-neighbours.

## Approach

- Scan every cell; each unvisited '*' starts a new component and increments the answer.
- Flood-fill the component with an iterative BFS over the 6 directions (a recursive DFS overflowed the stack for N = 100, so the solution switched to BFS and marks cells when they are pushed).

## Complexity

- **Time:** O(N³)
- **Space:** O(N³)

## Concepts

Flood Fill, BFS, 3D Grid

## Files

- [`src/DAC.java`](src/DAC.java)

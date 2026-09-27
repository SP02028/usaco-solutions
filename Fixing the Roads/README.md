# Fixing the Roads

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

A directed road network has N intersections and M one-way roads. You may travel against a road's direction by paying 1 to fix it. Find the minimum number of roads to fix to get from A to B.

## Approach

- Build a graph where each road gives a free forward edge (weight 0) and a reversed edge of weight 1.
- Run 0-1 BFS with a deque: weight-0 edges go to the front and weight-1 edges to the back.

## Complexity

- **Time:** O(N + M)
- **Space:** O(N + M)

## Concepts

0-1 BFS, Shortest Paths

## Files

- [`src/FtR.java`](src/FtR.java)

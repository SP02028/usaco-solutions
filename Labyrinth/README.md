# Labyrinth

**Source:** [Codeforces 1063B — Labyrinth](https://codeforces.com/contest/1063/problem/B)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

In an n×m maze, starting from a cell you may move up and down freely, but at most x moves left and at most y moves right. Count the reachable cells.

## Approach

- For a cell at column c, right moves minus left moves is fixed (c − startC), so it is enough to minimize left moves.
- Run 0-1 BFS where a left move costs 1 and all other moves cost 0; a cell is reachable iff its minimal left count L ≤ x and L + (c − startC) ≤ y.

## Complexity

- **Time:** O(n · m)
- **Space:** O(n · m)

## Concepts

0-1 BFS, Grid Graphs

## Files

- [`src/L.java`](src/L.java)

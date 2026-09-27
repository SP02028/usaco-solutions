# Counting Rooms

**Source:** [CSES Problem Set — Counting Rooms](https://cses.fi/problemset/task/1192)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Count connected components of floor cells ('.') in an n×m grid of floors and walls.

## Approach

- Scan the grid and start a recursive flood fill from each unvisited floor cell, incrementing the count.

## Complexity

- **Time:** O(n · m)
- **Space:** O(n · m)

## Concepts

Flood Fill, DFS

## Files

- [`src/CR.java`](src/CR.java)

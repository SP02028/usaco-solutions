# Solve The Maze

**Source:** [Codeforces 1365D — Solve The Maze](https://codeforces.com/contest/1365/problem/D)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

A grid has good people (G), bad people (B), walls and empty cells, with the exit at the bottom-right. Add walls so that every good person can escape and no bad person can.

## Approach

- Surround every bad person with walls; if a good person is adjacent to a bad one, the answer is No.
- Flood fill from the exit and check that every good person is reached.

## Complexity

- **Time:** O(n · m)
- **Space:** O(n · m)

## Concepts

Flood Fill, Greedy, Grid

## Files

- [`src/STM.java`](src/STM.java)

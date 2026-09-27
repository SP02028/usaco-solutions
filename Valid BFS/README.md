# Valid BFS?

**Source:** [Codeforces 1037D — Valid BFS?](https://codeforces.com/contest/1037/problem/D)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 34 official Codeforces tests that are published in full.

## Problem

Given a tree and a sequence, decide whether the sequence is a valid BFS order starting from vertex 1.

## Approach

- Simulate a BFS driven by the sequence: when a vertex is dequeued, its unvisited neighbours must appear next in the sequence (in any order). Check membership with a set and enqueue them in sequence order.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

BFS, Simulation

## Files

- [`src/VBFS.java`](src/VBFS.java)

# Robot on the Board 1

**Source:** [Codeforces 1607E — Robot on the Board 1](https://codeforces.com/contest/1607/problem/E)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A robot follows a command string on an n×m board and stops before the first move that would leave the board. Choose the starting cell that maximizes the number of executed commands.

## Approach

- Track the running min/max row and column offsets. While the bounding box of offsets fits in n×m, the start (1 − minRow, 1 − minCol) works; stop at the first command that makes it too large.

## Complexity

- **Time:** O(|s|) per test case
- **Space:** O(1)

## Concepts

Simulation, Bounding Box

## Files

- [`src/RotB1.java`](src/RotB1.java)

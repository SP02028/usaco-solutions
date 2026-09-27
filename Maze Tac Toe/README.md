# Maze Tac Toe

**Source:** [USACO 2021 US Open Contest, Silver — Problem 1: Maze Tac Toe](https://usaco.org/index.php?page=viewproblem2&cpid=1134)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie walks an N×N maze whose cells contain moves like "M at (i, j)" or "O at (i, j)" on a 3×3 tic-tac-toe board, applied when first stepped on (and only if that board cell is empty). Count the distinct winning board states she can reach, where a win is MOO in a line.

## Approach

- Encode the board as a base-3 number (3⁹ states) and search over (cell, board) states with BFS/DFS, marking visited pairs.
- When a move is applied, check whether the new board contains M-O-O in any row, column or diagonal; if so, record it and stop expanding.
- Count the distinct winning boards.

## Complexity

- **Time:** O(N² · 3⁹)
- **Space:** O(N² · 3⁹)

## Concepts

BFS over States, Bitmask/Base-3 Encoding

## Files

- [`previous/MazeTacToe.java`](previous/MazeTacToe.java)
- [`src/MazeTacToe.java`](src/MazeTacToe.java)

## Notes

An earlier variant of the solution that was uploaded as a top-level file is kept in `previous/`.

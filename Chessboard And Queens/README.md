# Chessboard and Queens

**Source:** [CSES Problem Set — Chessboard and Queens](https://cses.fi/problemset/task/1624)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Count ways to place 8 non-attacking queens on an 8×8 board where some squares are reserved and cannot be used.

## Approach

- Enumerate all 8! permutations (queen in each row at a distinct column), skip any that uses a reserved square, and check the two diagonal directions with hash sets.

## Complexity

- **Time:** O(8! · 8)
- **Space:** O(8!) (all permutations are stored)

## Concepts

Complete Search, Permutations, Backtracking

## Files

- [`src/cq.java`](src/cq.java)

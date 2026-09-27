# Maximal Binary Matrix

**Source:** [Codeforces 803A — Maximal Binary Matrix](https://codeforces.com/contest/803/problem/A)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Place k ones in an n×n zero matrix so that it is symmetric about the main diagonal and lexicographically maximal, or print −1.

## Approach

- Fill greedily row by row: a diagonal cell costs 1 one, an off-diagonal pair (i, j), (j, i) costs 2. Take each cell in order if enough ones remain.

## Complexity

- **Time:** O(n²)
- **Space:** O(n²)

## Concepts

Greedy, Constructive

## Files

- [`src/MBM.java`](src/MBM.java)

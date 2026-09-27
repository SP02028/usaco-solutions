# Mooyo Mooyo

**Source:** [USACO 2018 December Contest, Silver — Problem 3: Mooyo Mooyo](https://usaco.org/index.php?page=viewproblem2&cpid=860)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A 10-column grid of coloured haybales: any connected same-colour region of size ≥ K disappears, then gravity pulls everything down, repeating until nothing changes. Output the final grid.

## Approach

- Repeatedly find all regions of size ≥ K with BFS, clear them, and apply gravity column by column (compacting non-empty cells to the bottom).
- Stop when a round removes nothing.

## Complexity

- **Time:** O(rounds · N · 10)
- **Space:** O(N · 10)

## Concepts

Flood Fill, Simulation

## Files

- [`src/MM.java`](src/MM.java)

## Notes

Uses USACO file I/O (`mooyomooyo.in` / `mooyomooyo.out`).

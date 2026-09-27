# Map of Sweeden

**Source:** [Kattis — sverigekartan](https://open.kattis.com/problems/sverigekartan)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Starting from the cell marked S on a grid map, count the connected region of land around it; after each query that marks a cell, output the updated region size.

## Approach

- Flood fill from S to mark and count the initial region.
- For each query, mark the cell and, if it touches the current region, flood fill from it to absorb the newly connected cells, updating the running size.

## Complexity

- **Time:** O(M · N) total across all flood fills
- **Space:** O(M · N)

## Concepts

Flood Fill, Incremental Connectivity

## Files

- [`src/MOS.java`](src/MOS.java)

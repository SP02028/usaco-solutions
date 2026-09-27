# Stuck in a Rut

**Source:** [USACO 2020 December Contest, Silver — Problem 3: Stuck in a Rut](https://usaco.org/index.php?page=viewproblem2&cpid=1064) · [USACO 2020 December Contest, Bronze — Problem 3: Stuck in a Rut](https://usaco.org/index.php?page=viewproblem2&cpid=1061)  
**Difficulty:** Silver  
**Verified:**
- `previous/SIAR.java`: ✅ Passes all 10 official USACO test cases (USACO Silver version).
- `src/SIAR.java`: ✅ Passes all 10 official USACO test cases (USACO Silver version).
- `src/stuckinarut.java`: ✅ Passes all 10 official USACO test cases (USACO Bronze version).

## Problem

Silver version: cows moving north or east stop when they reach grass another cow already ate. For each cow, output how many cows it blamed (stopped directly or indirectly).

## Approach

- Sort east cows by y and north cows by x, then examine every crossing pair in that order. The cow that reaches the intersection later is stopped (if neither is already stopped), and the blocking cow's blame grows by 1 plus the stopped cow's blame.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Simulation, Sorting

## Files

- [`previous/SIAR.java`](previous/SIAR.java)
- [`src/SIAR.java`](src/SIAR.java)
- [`src/stuckinarut.java`](src/stuckinarut.java)

## Notes

`SIAR.java` solves the Silver version and `stuckinarut.java` solves the Bronze version (the grass each cow eats, or Infinity). An earlier copy of the Silver solution uploaded as a top-level file is kept in `previous/`.

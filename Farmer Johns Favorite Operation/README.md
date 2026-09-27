# Farmer John's Favorite Operation

**Source:** [USACO 2025 January Contest, Silver — Problem 2: Farmer John's Favorite Operation](https://usaco.org/index.php?page=viewproblem2&cpid=1471)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

Same problem as `Farmer John's Favorite Operation`: pick x to minimize the total circular distance Σ min(|a_i − x| mod M, M − …).

## Approach

- Sweep the circle over slope-change points (each a_i and its opposite point) stored in a TreeMap, starting from the exact cost and slope at x = 0, and track the minimum cost.

## Complexity

- **Time:** O(N log N) per test case
- **Space:** O(N)

## Concepts

Sweep Line, Piecewise Linear Functions

## Files

- [`src/FJFO.java`](src/FJFO.java)
- [`src/FJFO2.java`](src/FJFO2.java)

## Notes

The comments in `FJFO.java` record two bugs that were fixed: peaks for odd M collapsing onto one point, and the starting slope at the wraparound. `FJFO2.java` is the same solution with shorter comments, originally uploaded as a top-level file.

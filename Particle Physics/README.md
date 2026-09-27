# Wormholes

**Source:** [USACO 2013 December Contest, Bronze — Problem 3: Wormholes](https://usaco.org/index.php?page=viewproblem2&cpid=360)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N portals sit at points in the plane and must be paired up. A particle moving in the +x direction enters a portal and exits at its partner, then continues in +x. Count the pairings in which some starting point leads to an infinite loop.

## Approach

- Precompute next[i], the first portal directly to the right of portal i on the same y.
- Backtrack over all perfect pairings. For each complete pairing, simulate from every portal (partner, then next) for N steps; if the walk never falls off, a cycle exists.

## Complexity

- **Time:** O((N − 1)!! · N²)
- **Space:** O(N)

## Concepts

Backtracking, Complete Search, Cycle Detection

## Files

- [`src/PP.java`](src/PP.java)

## Notes

This is AlphaStar's reworded version of USACO 2013 December Bronze "Wormholes"; the folder keeps the AlphaStar title.

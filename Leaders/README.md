# Leaders

**Source:** [USACO 2023 January Contest, Bronze — Problem 1: Leaders](https://usaco.org/index.php?page=viewproblem2&cpid=1275)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 17 official USACO test cases.

## Problem

N cows of breeds G and H each list a contiguous range of cows starting at themselves. A leader's list must contain all cows of her breed or the other breed's leader. Count the possible leader pairs.

## Approach

- The G leader must be the first G if that cow covers every G. Otherwise a G leader must cover the first H who covers all H's; the same holds for H.
- Count pairs where the earliest G (or an earlier G covering the earliest H) and the earliest H (or an earlier H covering the earliest G) satisfy these rules.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Case Analysis, Greedy

## Files

- [`src/L.java`](src/L.java)

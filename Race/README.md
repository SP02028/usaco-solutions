# Race

**Source:** [USACO 2020 January Contest, Bronze — Problem 3: Race](https://usaco.org/index.php?page=viewproblem2&cpid=989)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie runs a race of length K, speeding up or slowing down by at most 1 per second, starting at speed 0, and she must finish at speed at most X. For each query X, find the minimum time.

## Approach

- Simulate speeding up one unit at a time. Once the speed reaches X, pair every further acceleration step with a matching deceleration step, counting the distance of both. Stop as soon as the total distance reaches K.

## Complexity

- **Time:** O(√K) per query
- **Space:** O(1)

## Concepts

Simulation, Math

## Files

- [`src/R.java`](src/R.java)

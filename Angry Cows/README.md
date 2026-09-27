# Angry Cows

**Source:** [USACO 2016 January Contest, Gold — Problem 1: Angry Cows](https://usaco.org/index.php?page=viewproblem2&cpid=597)  
**Difficulty:** Gold  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Hay bales sit at integer positions. Launch one cow with power R at any real position; a bale exploding with radius r triggers bales within r, and those explode with radius r − 1, and so on. Find the minimum R that detonates every bale.

## Approach

- Double all coordinates so half-integers become integers, then binary search on R.
- For a given R, binary search the rightmost launch position whose chain can still reach the leftmost bale, then check whether the chain from that position reaches the rightmost bale.
- The left and right chains are simulated recursively, with power dropping by one at each step.

## Complexity

- **Time:** O(N log N · log C)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Simulation, Sorting

## Files

- [`src/AC.java`](src/AC.java)
- [`angry.out`](angry.out)

## Notes

The `angry.out` file is sample output kept from a local run.

# Air Cownditioning

**Source:** [USACO 2021 December Contest, Bronze — Problem 2: Air Cownditioning](https://usaco.org/index.php?page=viewproblem2&cpid=1156)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Each stall i has a current temperature t_i and a desired temperature p_i. One command raises or lowers the temperature of a contiguous range of stalls by 1. Find the minimum number of commands.

## Approach

- Work with the differences d_i = p_i − t_i.
- Repeatedly take the maximal run at the end of the array whose values are nonzero and share a sign, move all of them one step toward 0 with one command, and count commands until every difference is 0.

## Complexity

- **Time:** O(N · max|d|)
- **Space:** O(N)

## Concepts

Greedy, Difference Array, Simulation

## Files

- [`src/acd.java`](src/acd.java)

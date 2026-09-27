# Drought

**Source:** [USACO 2022 January Contest, Bronze — Problem 3: Drought](https://usaco.org/index.php?page=viewproblem2&cpid=1181)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

N cows have hunger levels h_i. Feeding two adjacent cows lowers both by 1. Find the minimum number of bags of corn (each bag feeds two cows) to make all hunger levels equal, or −1.

## Approach

- Sweep left to right. If h[i+1] > h[i], the extra must be removed by feeding the pair (i+1, i+2) diff times, costing 2·diff; fail if that pushes h[i+2] below 0 or no such pair exists.
- If h[i] > h[i+1], the whole prefix must be lowered, which is possible only when the prefix length i is even; that costs diff·i.

## Complexity

- **Time:** O(N) per test case
- **Space:** O(N)

## Concepts

Greedy, Simulation

## Files

- [`src/D.java`](src/D.java)

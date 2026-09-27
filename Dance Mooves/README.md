# Dance Mooves

**Source:** [USACO 2021 January Contest, Silver — Problem 1: Dance Mooves](https://usaco.org/index.php?page=viewproblem2&cpid=1086)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

N cows start in positions 1..N and a fixed list of K swaps repeats forever. For each cow, count the distinct positions she ever visits.

## Approach

- Simulate one round of K swaps, recording every position each cow visits.
- After one round the cows are permuted; cows in the same cycle of that permutation eventually visit the union of each other's positions.
- For every cycle, take the union of its members' visited sets and assign its size to every cow in the cycle.

## Complexity

- **Time:** O(N + K)
- **Space:** O(N + K)

## Concepts

Permutation Cycles, Simulation, Sets

## Files

- [`src/DM.java`](src/DM.java)

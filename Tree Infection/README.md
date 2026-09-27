# Tree Infection

**Source:** [Codeforces 1665C — Tree Infection](https://codeforces.com/contest/1665/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A rooted tree; each second you may inject one vertex, and infection spreads to one more child of each group of siblings that already has an infected member. Find the minimum time to infect everything.

## Approach

- Group vertices by parent (plus the root as its own group) and sort group sizes descending. Seed the largest group first, one group per second; each group then grows by one per second.
- Any remaining excess is removed by simulating extra injections on the currently largest groups, one per second.

## Complexity

- **Time:** O(n log n) per test case
- **Space:** O(n)

## Concepts

Greedy, Simulation, Sorting

## Files

- [`src/TreeInfection.java`](src/TreeInfection.java)

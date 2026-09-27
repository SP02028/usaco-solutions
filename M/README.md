# Moocast

**Source:** [USACO 2016 December Contest, Silver — Problem 3: Moocast](https://usaco.org/index.php?page=viewproblem2&cpid=668)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Each cow has a walkie-talkie range and can relay messages. Find the maximum number of cows that can hear a broadcast started from a single cow (Moocast).

## Approach

- Build a directed graph with an edge i → j when j is within cow i's power.
- DFS from every cow and take the largest reachable set.

## Complexity

- **Time:** O(N³)
- **Space:** O(N²)

## Concepts

Graphs, DFS

## Files

- [`M.java`](M.java)

## Notes

The folder name is short for Moocast. Uses USACO file I/O (`moocast.in` / `moocast.out`).

# Majority Opinion

**Source:** [USACO 2024 January Contest, Bronze — Problem 1: Majority Opinion](https://usaco.org/index.php?page=viewproblem2&cpid=1371)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

Cows have hay preferences. A focus group on a range converts everyone to a strict-majority type. Output every type that can end up as everyone's preference, or −1.

## Approach

- A type can win iff two occurrences are adjacent or one apart (h[i] = h[i+1] or h[i] = h[i+2]); such a length-2 or length-3 majority can then be spread everywhere.

## Complexity

- **Time:** O(N) per test case
- **Space:** O(N)

## Concepts

Observation, Constructive

## Files

- [`src/MO.java`](src/MO.java)

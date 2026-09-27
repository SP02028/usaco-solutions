# Carrot Cakes

**Source:** [Codeforces 799A — Carrot Cakes](https://codeforces.com/contest/799/problem/A)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

One oven bakes k cakes every t minutes; building a second oven takes d minutes. Decide whether building the second oven strictly reduces the time to bake n cakes.

## Approach

- Simulate the first oven alone during the d minutes it takes to build the second; if cakes are still needed after that point, the second oven helps (YES), otherwise NO.

## Complexity

- **Time:** O(d / t)
- **Space:** O(1)

## Concepts

Simulation

## Files

- [`src/CC.java`](src/CC.java)

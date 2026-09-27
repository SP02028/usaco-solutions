# New Building for SIS

**Source:** [Codeforces 1020A — New Building for SIS](https://codeforces.com/contest/1020/problem/A)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

A building has n towers of h floors; you can move between towers only on floors a..b, and each move costs 1. Answer queries for the minimum travel time between two locations.

## Approach

- Within one tower, the answer is the floor difference.
- Otherwise you must cross towers on some floor in [a, b]: clamp the starting floor to that range, then add the horizontal distance and the vertical distances.

## Complexity

- **Time:** O(1) per query
- **Space:** O(1)

## Concepts

Math, Case Analysis

## Files

- [`src/NBFSIS.java`](src/NBFSIS.java)

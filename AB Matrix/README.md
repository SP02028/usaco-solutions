# A/B Matrix

**Source:** [Codeforces 1360G — A/B Matrix](https://codeforces.com/contest/1360/problem/G)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full, checked with a custom validator because more than one answer is accepted.

## Problem

Build an n×m binary matrix where every row has exactly a ones and every column has exactly b ones, or report that it is impossible.

## Approach

- Counting ones by rows and by columns gives n·a = m·b; if this fails, print NO.
- Otherwise fill each row with a consecutive ones (cyclically), starting where the previous row stopped. The cyclic shift spreads ones evenly so every column receives exactly b.

## Complexity

- **Time:** O(n·m)
- **Space:** O(n·m)

## Concepts

Constructive, Cyclic Shift

## Files

- [`src/ABM.java`](src/ABM.java)

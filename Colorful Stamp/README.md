# Colorful Stamp

**Source:** [Codeforces 1669D — Colorful Stamp](https://codeforces.com/contest/1669/problem/D)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

A stamp paints two adjacent cells, one R and one B (in either order), and stamps may overlap. Decide whether a given R/B/W row can be produced.

## Approach

- Split the string by 'W'. Each non-empty segment is reachable iff it contains at least one R and at least one B.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Strings, Observation

## Files

- [`src/CS.java`](src/CS.java)

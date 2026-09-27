# Painting the Fence

**Source:** [Codeforces 1132C — Painting the Fence](https://codeforces.com/contest/1132/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

A fence of n sections and q painters, each painting a range. Hire exactly q − 2 painters to maximize the number of painted sections.

## Approach

- Fix the first painter to drop. Build the coverage of the remaining painters with a difference array, count painted sections, and build a prefix count of sections covered exactly once.
- Dropping a second painter j loses exactly the sections in j's range covered once, so take total − that loss and maximize over pairs.

## Complexity

- **Time:** O(q · (n + q))
- **Space:** O(n + q)

## Concepts

Difference Arrays, Prefix Sums

## Files

- [`src/PTF.java`](src/PTF.java)

# Cow Evolution

**Source:** [USACO 2019 US Open Contest, Bronze — Problem 3: Cow Evolution](https://usaco.org/index.php?page=viewproblem2&cpid=941)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 17 official USACO test cases.

## Problem

Given the set of characteristics of each of N sub-populations, decide whether they could have evolved in a proper tree (each characteristic evolves exactly once).

## Approach

- A proper tree is impossible exactly when two characteristics A and B both appear together, with A alone, and with B alone.
- Check every pair of characteristics against all sub-populations.

## Complexity

- **Time:** O(C² · N) for C distinct characteristics
- **Space:** O(N · C)

## Concepts

Complete Search, Sets

## Files

- [`src/CE.java`](src/CE.java)

## Notes

Uses USACO file I/O (`evolution.in` / `evolution.out`).

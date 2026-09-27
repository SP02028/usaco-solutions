# Shifted MEX

**Source:** [Codeforces 2185C — Shifted MEX](https://codeforces.com/contest/2185/problem/C)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

You may add the same integer to every element of the array. Maximize the MEX.

## Approach

- Shifting lets any value become 0, so the answer is the longest run of consecutive integers present in the array (duplicates allowed).
- Sort and scan for maximal runs where each next value is the previous value or previous + 1, counting distinct values.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Observation

## Files

- [`src/SM.java`](src/SM.java)

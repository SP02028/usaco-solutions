# Secret Cow Code

**Source:** [USACO 2017 January Contest, Silver — Problem 3: Secret Cow Code](https://usaco.org/index.php?page=viewproblem2&cpid=692)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A string is repeatedly extended by appending its rotation (last character first) to itself. Find the N-th character of the infinite string.

## Approach

- Find the smallest length L (the string length doubled repeatedly) that covers N.
- If N is in the second half, map it back to the first half: position L maps to L−1, and other positions subtract L + 1. Recurse until N falls inside the original string.

## Complexity

- **Time:** O(log² N)
- **Space:** O(log N) recursion

## Concepts

Recursion, Divide and Conquer

## Files

- [`src/SCC.java`](src/SCC.java)

## Notes

Uses USACO file I/O (`cowcode.in` / `cowcode.out`).

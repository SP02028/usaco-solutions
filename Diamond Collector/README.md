# Diamond Collector

**Source:** [USACO 2016 US Open Contest, Silver — Problem 2: Diamond Collector](https://usaco.org/index.php?page=viewproblem2&cpid=643)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Same as `DC`: display as many diamonds as possible in two cases, where each case's diamond sizes differ by at most K.

## Approach

- Sort sizes. Compute, for each index, the best single case entirely at or before it (prefix best) and entirely at or after it (suffix best) using two pointers.
- Try every split point and take the maximum of prefixBest[i] + suffixBest[i + 1].

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Two Pointers, Prefix/Suffix Maximum

## Files

- [`src/DC.java`](src/DC.java)

## Notes

Uses USACO file I/O (`diamond.in` / `diamond.out`).

# The Tower is Going Home

**Source:** [Codeforces 1044A — The Tower is Going Home](https://codeforces.com/contest/1044/problem/A)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 8 official Codeforces tests that are published in full.

## Problem

A rook at (1, 1) wants to reach row 10⁹. There are vertical blocking lines and horizontal segments; remove the minimum number of blockers so the rook can reach the top.

## Approach

- Only horizontal segments starting at column 1 matter. Sort the vertical lines and the right ends of those segments.
- If we remove the i leftmost vertical lines, the rook can use columns up to the next vertical line, and must remove every horizontal segment reaching at least that far. Minimize over i with two pointers.

## Complexity

- **Time:** O((n + m) log(n + m))
- **Space:** O(n + m)

## Concepts

Sorting, Two Pointers, Greedy

## Files

- [`src/TTiGH.java`](src/TTiGH.java)

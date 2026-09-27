# Vasya and Robot

**Source:** [Codeforces 1073C — Vasya and Robot](https://codeforces.com/contest/1073/problem/C)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Change a contiguous segment of the robot's command string (of minimum length) so it ends at (x, y), or print −1.

## Approach

- If the target is too far or has the wrong parity, print −1. Otherwise binary search the segment length.
- For a given length, slide a window over the string, keeping the displacement of the commands outside the window; the window can fix things iff the remaining Manhattan distance is ≤ its length with matching parity.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Binary Search on Answer, Sliding Window

## Files

- [`src/VaR.java`](src/VaR.java)

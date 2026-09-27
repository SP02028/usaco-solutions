# Magic Ship

**Source:** [Codeforces 1117C — Magic Ship](https://codeforces.com/contest/1117/problem/C)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 6 official Codeforces tests that are published in full.

## Problem

A ship starts at (x1, y1) and wants to reach (x2, y2). Wind blows according to a periodic string of length n, and each day the ship can also move one step or stay. Find the minimum number of days, or −1.

## Approach

- Binary search on the number of days d: the wind's total displacement comes from full cycles plus a prefix, and d days suffice iff the remaining Manhattan distance is ≤ d.

## Complexity

- **Time:** O(n + log(answer))
- **Space:** O(n)

## Concepts

Binary Search on Answer, Prefix Sums

## Files

- [`src/MS.java`](src/MS.java)

# Long Legs

**Source:** [Codeforces 1814B — Long Legs](https://codeforces.com/contest/1814/problem/B)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 7 official Codeforces tests that are published in full.

## Problem

A robot starts with leg length 1 and can increase it by 1 or jump by the current length in x or y. Find the minimum number of moves to reach (a, b).

## Approach

- If the final length is m, the cost is (m − 1) + ceil(a/m) + ceil(b/m). Try every m up to about 10⁵ and take the minimum.

## Complexity

- **Time:** O(10⁵) per test case
- **Space:** O(1)

## Concepts

Brute Force, Math

## Files

- [`src/LL.java`](src/LL.java)

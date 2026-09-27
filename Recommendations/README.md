# Recommendations

**Source:** [Codeforces 1310A — Recommendations](https://codeforces.com/contest/1310/problem/A)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

n categories have initial publication counts a_i, and adding one publication to category i costs t_i. Make all counts distinct at minimum total cost.

## Approach

- Sweep counts upward. At each value, all categories currently wanting it sit in a max-heap by cost. The most expensive one keeps the value, and the rest move up by one, paying the sum of their costs (tracked in costsum).
- When the heap empties, jump to the next initial count.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Priority Queue, Sweep

## Files

- [`src/R.java`](src/R.java)

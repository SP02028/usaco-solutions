# Save More Mice

**Source:** [Codeforces 1593C — Save More Mice](https://codeforces.com/contest/1593/problem/C)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Mice on a line run toward a hole at n while a cat walks from 0 toward the hole; each second one mouse moves one step. Maximize the number of mice that reach the hole before the cat catches them.

## Approach

- Save the mice closest to the hole first. Keep adding them while the total distance they need is less than n (the cat's distance).

## Complexity

- **Time:** O(k log k) per test case
- **Space:** O(k)

## Concepts

Greedy, Sorting

## Files

- [`src/SMM.java`](src/SMM.java)

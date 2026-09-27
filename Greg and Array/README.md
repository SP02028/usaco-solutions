# Greg and Array

**Source:** [Codeforces 295A — Greg and Array](https://codeforces.com/contest/295/problem/A)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

An array, m range-add operations, and k queries each applying a range of operations. Output the final array.

## Approach

- Use a difference array over operation indices to count how many times each operation is applied.
- Use a second difference array over the main array to apply each operation's value times its count.

## Complexity

- **Time:** O(n + m + k)
- **Space:** O(n + m)

## Concepts

Difference Arrays, Prefix Sums

## Files

- [`src/GA.java`](src/GA.java)

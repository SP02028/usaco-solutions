# Update Queries

**Source:** [Codeforces 1986C — Update Queries](https://codeforces.com/contest/1986/problem/C)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Apply m updates s[ind_i] = c_i in an order you choose, and you may also reorder c. Obtain the lexicographically smallest final string.

## Approach

- Only distinct indices matter. Sort them, sort the letters, and assign the smallest letters to the smallest indices.

## Complexity

- **Time:** O(n + m log m)
- **Space:** O(m)

## Concepts

Greedy, Sorting

## Files

- [`src/UQ.java`](src/UQ.java)

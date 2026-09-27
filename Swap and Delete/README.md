# Swap and Delete

**Source:** [Codeforces 1913B — Swap and Delete](https://codeforces.com/contest/1913/problem/B)  
**Difficulty:** Codeforces rating 1000  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

With deletions (cost 1) and free swaps, turn s into a string t that differs from s at every position. Minimize the cost.

## Approach

- Build t greedily from the multiset of s's characters: position i needs a character different from s_i. Stop at the first position where none remains; everything after it must be deleted.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(1)

## Concepts

Greedy, Counting

## Files

- [`src/SaD.java`](src/SaD.java)

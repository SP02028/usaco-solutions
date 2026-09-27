# Game with Multiset

**Source:** [Codeforces 1913C — Game with Multiset](https://codeforces.com/contest/1913/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Process queries: add 2^x to a multiset, or ask whether some sub-multiset sums to w.

## Approach

- Keep counts of each power of two. For a query, greedily take as many of the largest powers as fit (up to their count), from 2^29 down to 2^0; the answer is YES iff the remainder becomes 0.

## Complexity

- **Time:** O(30) per query
- **Space:** O(30)

## Concepts

Greedy, Bit Manipulation

## Files

- [`src/GWM.java`](src/GWM.java)

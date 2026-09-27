# Strange Partition

**Source:** [Codeforces 1471A — Strange Partition](https://codeforces.com/contest/1471/problem/A)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes all 11 official Codeforces tests that are published in full.

## Problem

You may merge adjacent elements. The beauty is Σ ceil(a_i / x). Output the minimum and maximum beauty.

## Approach

- Merging never increases the sum of ceilings, so the maximum is with no merges (Σ ceil(a_i / x)) and the minimum is with everything merged (ceil(Σa / x)).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Math, Ceiling Division

## Files

- [`src/SP.java`](src/SP.java)

# Good Subarrays

**Source:** [Codeforces 1398C — Good Subarrays](https://codeforces.com/contest/1398/problem/C)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Given a digit string, count subarrays whose digit sum equals their length.

## Approach

- Subtract 1 from every digit; a subarray is good iff its transformed sum is 0, which means two prefix values P_i − i are equal.
- Count equal prefix values with a HashMap and add C(count, 2) for each value.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Prefix Sums, Hashing

## Files

- [`src/GS.java`](src/GS.java)

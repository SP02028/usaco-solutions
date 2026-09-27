# ABBC or BACB

**Source:** [Codeforces 1873G — ABBC or BACB](https://codeforces.com/contest/1873/problem/G)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A string of A's and B's; an operation turns "AB" into "BC" or "BA" into "CB" and earns a coin. Find the maximum number of coins.

## Approach

- Every A can be consumed by some B unless the B's can't reach every block of A's.
- If the string starts or ends with B, or contains "BB", every A can be consumed: answer = number of A's.
- Otherwise exactly one block of A's must be sacrificed, so drop the smallest A-block: answer = total A's − smallest block.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Strings

## Files

- [`src/abbcbacb.java`](src/abbcbacb.java)

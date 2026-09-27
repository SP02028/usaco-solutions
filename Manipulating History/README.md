# Manipulating History

**Source:** [Codeforces 1688C — Manipulating History](https://codeforces.com/contest/1688/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A one-letter string was transformed by n replace operations, and all 2n involved strings plus the final string are given shuffled. Find the initial letter.

## Approach

- Every letter except the initial one appears an even number of times across all the given strings, so output the letter with an odd total count.

## Complexity

- **Time:** O(total length)
- **Space:** O(26)

## Concepts

Parity, Counting

## Files

- [`src/MH.java`](src/MH.java)

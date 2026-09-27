# Interesting Story

**Source:** [Codeforces 1551C — Interesting Story](https://codeforces.com/contest/1551/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Choose the largest set of words such that some letter from a–e appears more often in total than all other letters combined.

## Approach

- For each letter c, score each word as 2·count(c) − length.
- Sort scores descending and take the longest prefix whose running sum stays positive; the answer is the maximum over the five letters.

## Complexity

- **Time:** O(5 · n log n)
- **Space:** O(n)

## Concepts

Greedy, Sorting

## Files

- [`src/IS.java`](src/IS.java)

## Notes

The folder name is a misspelling of "Interesting Story".

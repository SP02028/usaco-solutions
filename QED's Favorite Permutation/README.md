# QED's Favorite Permutation

**Source:** [Codeforces 2030D — QED's Favorite Permutation](https://codeforces.com/contest/2030/problem/D)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A permutation can be sorted using swaps allowed by an L/R string (L allows swapping with the left neighbour, R with the right). After each query that flips one character, decide whether sorting is possible.

## Approach

- A boundary between positions i and i+1 is crossable unless s_i = 'L' and s_{i+1} = 'R'.
- A difference array counts how many values must cross each boundary. Keep the set of 'bad' boundaries (uncrossable but needed); each query changes at most two of them.

## Complexity

- **Time:** O(n + q) per test case
- **Space:** O(n)

## Concepts

Difference Arrays, Sets

## Files

- [`src/QEDFP.java`](src/QEDFP.java)

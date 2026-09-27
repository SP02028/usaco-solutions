# String Transformation 1

**Source:** [Codeforces 1383A — String Transformation 1](https://codeforces.com/contest/1383/problem/A)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

Transform string A into B (letters a–t) by repeatedly choosing a set of equal letters x in A and changing them all to some y > x. Find the minimum number of moves, or −1.

## Approach

- If some A_i > B_i, it is impossible.
- Otherwise build a graph over the 20 letters with an edge A_i–B_i for every mismatch. Each connected component with k letters needs exactly k − 1 moves, so the answer is 20 − (number of components).

## Complexity

- **Time:** O(n + 20²)
- **Space:** O(20)

## Concepts

Graphs, Connected Components, Greedy

## Files

- [`src/ST1.java`](src/ST1.java)

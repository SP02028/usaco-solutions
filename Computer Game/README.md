# Computer Game

**Source:** [Codeforces 1183C — Computer Game](https://codeforces.com/contest/1183/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

Vova has charge k and must play n turns. A normal turn costs a, a 'play and charge' turn costs b < a, and the charge must stay strictly positive. Maximize the number of normal turns, or print −1.

## Approach

- If even n cheap turns use up the whole charge (n·b ≥ k), it is impossible.
- Otherwise x normal turns need x·a + (n − x)·b < k, giving x = min(n, (k − n·b − 1) / (a − b)).

## Complexity

- **Time:** O(1) per query
- **Space:** O(1)

## Concepts

Math, Inequalities

## Files

- [`src/CG.java`](src/CG.java)

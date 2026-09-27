# Chip and Ribbon

**Source:** [Codeforces 1901B — Chip and Ribbon](https://codeforces.com/contest/1901/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A ribbon of n cells must end with cell i visited c_i times. Moving the chip right one cell counts as a visit and teleporting costs 1 operation. Find the minimum number of teleports (the chip starts in cell 1, which counts as one visit).

## Approach

- Each time the required count increases from cell i−1 to cell i, the extra visits must start with new teleports; decreases are free.
- Answer = (c_1 − 1) + Σ max(0, c_i − c_{i−1}).

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Greedy, Difference Arrays

## Files

- [`src/CAR.java`](src/CAR.java)

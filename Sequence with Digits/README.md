# Sequence with Digits

**Source:** [Codeforces 1355A — Sequence with Digits](https://codeforces.com/contest/1355/problem/A)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

a_{n+1} = a_n + minDigit(a_n) · maxDigit(a_n). Given a_1 and K, find a_K.

## Approach

- Once a zero digit appears the sequence stops changing, and that happens within about a thousand steps, so simulate until step K or until a 0 digit appears.

## Complexity

- **Time:** O(min(K, ~1000) · digits)
- **Space:** O(digits)

## Concepts

Simulation, Observation

## Files

- [`src/SQD.java`](src/SQD.java)

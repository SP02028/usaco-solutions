# Prefix Max

**Source:** [Codeforces 2185B — Prefix Max](https://codeforces.com/contest/2185/problem/B)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

You may perform one operation that sets some element to a value already in the array. Maximize the sum of prefix maxima.

## Approach

- Moving the maximum to the front makes every prefix maximum equal to it, so the answer is max(a) · n.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(1)

## Concepts

Observation, Greedy

## Files

- [`src/PM.java`](src/PM.java)

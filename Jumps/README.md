# Jumps

**Source:** [Codeforces 1455B — Jumps](https://codeforces.com/contest/1455/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

Starting at 0, on the k-th jump you move either +k or −1. Find the minimum number of jumps to reach x.

## Approach

- Find the smallest k with k(k+1)/2 ≥ x. If the overshoot is exactly 1, one extra jump is needed; otherwise replacing one +j step with −1 fixes any other overshoot.

## Complexity

- **Time:** O(√x) per test case
- **Space:** O(1)

## Concepts

Math, Greedy

## Files

- [`src/J.java`](src/J.java)

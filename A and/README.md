# A and B

**Source:** [Codeforces 1278B — A and B](https://codeforces.com/contest/1278/problem/B)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Given two integers a and b, in step i you may add i to either a or b. Find the minimum number of steps needed to make them equal.

## Approach

- Let d = |a − b|. After k steps the total added is k(k+1)/2, and the two numbers can be made equal iff that total is ≥ d and has the same parity as d.
- Increase k from 0 until both conditions hold.

## Complexity

- **Time:** O(√d) per test case
- **Space:** O(1)

## Concepts

Math, Parity

## Files

- [`src/AB.java`](src/AB.java)

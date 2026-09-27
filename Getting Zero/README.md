# Getting Zero

**Source:** [Codeforces 1661B — Getting Zero](https://codeforces.com/contest/1661/problem/B)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

With operations v := (v + 1) mod 32768 and v := 2v mod 32768, find the minimum number of operations to reach 0 from each a_i.

## Approach

- An optimal sequence adds first and then doubles. Try every number of additions i ≤ 15 and doublings j ≤ 15, and keep the minimum i + j with (a + i)·2^j ≡ 0 (mod 32768).

## Complexity

- **Time:** O(15² · n)
- **Space:** O(n)

## Concepts

Brute Force, Bit Manipulation

## Files

- [`src/GZ.java`](src/GZ.java)

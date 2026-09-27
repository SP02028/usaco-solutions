# Koxia and Number Theory

**Source:** [Codeforces 1770C — Koxia and Number Theory](https://codeforces.com/contest/1770/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Given n distinct-or-not integers, decide whether some positive x makes every pair a_i + x, a_j + x coprime.

## Approach

- Duplicate values make it impossible.
- For every small modulus m ≤ n/2, if every residue class mod m contains at least two elements, then any x leaves two numbers divisible by the same m, so the answer is NO. (Checking all m, not only primes, is sufficient.)

## Complexity

- **Time:** O(n²) per test case
- **Space:** O(n)

## Concepts

Number Theory, Pigeonhole Principle

## Files

- [`src/KANT.java`](src/KANT.java)

# Squares and Cubes

**Source:** [Codeforces 1619B — Squares and Cubes](https://codeforces.com/contest/1619/problem/B)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes all 40 official Codeforces tests that are published in full.

## Problem

Count the integers from 1 to n that are perfect squares or perfect cubes.

## Approach

- Insert every square and every cube ≤ n into a HashSet (removing duplicates such as sixth powers) and print its size.

## Complexity

- **Time:** O(√n) per test case
- **Space:** O(√n)

## Concepts

Math, Hashing

## Files

- [`src/SaC.java`](src/SaC.java)

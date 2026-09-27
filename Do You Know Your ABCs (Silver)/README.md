# Do You Know Your ABCs?

**Source:** [USACO 2021 US Open Contest, Silver — Problem 2: Do You Know Your ABCs?](https://usaco.org/index.php?page=viewproblem2&cpid=1135)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

Farmer John had three positive integers A ≤ B ≤ C and wrote down some N of the seven numbers A, B, C, A+B, B+C, C+A, A+B+C. Count the triples (A, B, C) consistent with the numbers he wrote.

## Approach

- Each of A, B, C must be either one of the given numbers or a difference of two of them; collect those candidates.
- Try every candidate triple with A ≤ B ≤ C and check that every given number appears among the seven values.

## Complexity

- **Time:** O(N⁶ · N) with N ≤ 7 (tiny)
- **Space:** O(N²)

## Concepts

Complete Search, Sets

## Files

- [`src/DYKYABCS.java`](src/DYKYABCS.java)

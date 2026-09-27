# MooBuzz

**Source:** [USACO 2019 December Contest, Silver — Problem 1: MooBuzz](https://usaco.org/index.php?page=viewproblem2&cpid=966)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

The Moo Buzz game skips numbers divisible by 3 or 5. Find the N-th number spoken.

## Approach

- Every block of 15 consecutive integers contains exactly 8 spoken numbers, in the pattern 1, 2, 4, 7, 8, 11, 13, 14.
- The answer is 15 · floor((N − 1)/8) + pattern[(N − 1) mod 8].

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Concepts

Math, Periodicity

## Files

- [`MB.java`](MB.java)

## Notes

The folder name is short for MooBuzz. Uses USACO file I/O (`moobuzz.in` / `moobuzz.out`).

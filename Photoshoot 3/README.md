# Photoshoot

**Source:** [USACO 2020 January Contest, Bronze — Problem 2: Photoshoot](https://usaco.org/index.php?page=viewproblem2&cpid=988)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given b_i = a_i + a_{i+1} for a hidden permutation a of 1..N, output the lexicographically smallest valid a.

## Approach

- Try a_1 = 1, 2, …. Each choice determines the whole sequence; the first choice that yields a valid permutation (values distinct and within 1..N) is the answer.

## Complexity

- **Time:** O(N²)
- **Space:** O(N)

## Concepts

Complete Search, Permutations

## Files

- [`src/P.java`](src/P.java)

## Notes

This is USACO 2020 January Bronze "Photoshoot".

# Uddered but not Herd

**Source:** [USACO 2021 January Contest, Bronze — Problem 1: Uddered but not Herd](https://usaco.org/index.php?page=viewproblem2&cpid=1083)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Cows moo the alphabet in a scrambled cowphabet order, repeatedly. Given the letters Farmer John heard, find the minimum number of complete cowphabet repetitions.

## Approach

- Scan the heard string; whenever the next letter does not come later in the cowphabet than the previous one, a new repetition must have started.

## Complexity

- **Time:** O(|heard| · 26)
- **Space:** O(1)

## Concepts

Greedy, Strings

## Files

- [`src/UbnH.java`](src/UbnH.java)

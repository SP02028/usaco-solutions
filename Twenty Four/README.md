# Twenty Four

**Source:** [Canadian Computing Competition 2008 Senior, Problem 4 (Twenty Four)](https://dmoj.ca/problem/ccc08s4)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

For each hand of four cards, find the largest value ≤ 24 obtainable by combining all four cards with +, −, × and exact division.

## Approach

- Enumerate every permutation of the cards and every choice of three operators, evaluating both bracket shapes ((a∘b)∘c)∘d and (a∘b)∘(c∘d), and skip divisions that are not exact.

## Complexity

- **Time:** O(4! · 4³) per hand
- **Space:** O(1)

## Concepts

Complete Search, Recursion, Permutations

## Files

- [`src/TF.java`](src/TF.java)

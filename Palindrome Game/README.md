# Palindrome Game

**Source:** [USACO 2024 February Contest, Bronze — Problem 1: Palindrome Game](https://usaco.org/index.php?page=viewproblem2&cpid=1395)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

Bessie and Elsie take turns removing a palindromic number of stones from a pile of S stones; whoever takes the last stone wins. Determine the winner.

## Approach

- Every single digit is a palindrome, and any multiple of 10 is losing for the player to move (they can never leave another multiple of 10). So the first player wins iff S mod 10 ≠ 0, which depends only on the last digit of S.

## Complexity

- **Time:** O(|S|) per test case
- **Space:** O(|S|)

## Concepts

Game Theory, Invariants

## Files

- [`src/PG.java`](src/PG.java)

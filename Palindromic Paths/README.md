# Palindromic Paths

**Source:** [Codeforces 1366C — Palindromic Paths](https://codeforces.com/contest/1366/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

In an n×m binary grid, change the minimum number of cells so that every monotone path from the top-left to the bottom-right reads as a palindrome.

## Approach

- Cells at distance d from the start and distance d from the end must all be equal. For each such pair of anti-diagonals, count the zeros and ones and add the smaller count (the middle diagonal is ignored).

## Complexity

- **Time:** O(n · m) per test case
- **Space:** O(n · m)

## Concepts

Grid, Palindromes, Greedy

## Files

- [`src/PP.java`](src/PP.java)

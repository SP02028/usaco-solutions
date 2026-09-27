# Bovine Genomics

**Source:** [USACO 2017 US Open Contest, Bronze — Problem 2: Bovine Genomics](https://usaco.org/index.php?page=viewproblem2&cpid=736)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

There are N spotty and N plain cows, each with a genome of length M. Count the positions whose letter alone perfectly distinguishes spotty from plain cows (no letter appears at that position in both groups).

## Approach

- For each position, collect the letters of the spotty cows and check whether any plain cow has one of them; if none does, the position counts.

## Complexity

- **Time:** O(M · N²)
- **Space:** O(N · M)

## Concepts

Complete Search, Strings

## Files

- [`src/Main.java`](src/Main.java)

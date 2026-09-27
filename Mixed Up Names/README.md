# Scrambled Letters

**Source:** [USACO 2012 December Contest, Bronze — Problem 2: Scrambled Letters](https://usaco.org/index.php?page=viewproblem2&cpid=206)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Each of N cow names has been scrambled. For each cow, find the earliest and latest position its name could occupy when all scrambled names are sorted alphabetically.

## Approach

- The best case for a cow is her letters sorted ascending while every other cow's letters are sorted descending; the worst case is the reverse.
- Sort the ascending and the descending versions of all names. Binary search to count how many other names must come before or after in each case.

## Complexity

- **Time:** O(N log N · L)
- **Space:** O(N · L)

## Concepts

Sorting, Binary Search, Strings

## Files

- [`src/MUN.java`](src/MUN.java)

## Notes

This is AlphaStar's reworded version of USACO 2012 December Bronze "Scrambled Letters"; the folder keeps the AlphaStar title.

# Typo

**Source:** [USACO 2012 November Contest, Bronze — Problem 2: Typo](https://usaco.org/index.php?page=viewproblem2&cpid=188)  
**Difficulty:** Silver (this contest predates Platinum, so its Bronze division was Silver-level)  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A bracelet is described by a string of '(' and ')'. Report how many characters have to be read before the string first becomes unbalanced, checking both from the left and (with brackets mirrored) from the right, and print the larger of the two values (0 if neither direction ever becomes unbalanced).

## Approach

- Scan left to right counting '(' and ')'; the first time closes exceed opens, return the number of closes seen.
- Reverse the string and swap every bracket, then run the same scan to handle the right-to-left direction.
- Print the maximum of the two scans.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Bracket Sequences, Prefix Balance

## Files

- [`src/AB.java`](src/AB.java)

## Notes

This is AlphaStar's reworded version of USACO 2012 November Bronze "Typo"; the folder keeps the AlphaStar title.

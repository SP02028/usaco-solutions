# It's Mooin' Time

**Source:** [USACO 2024 December Contest, Bronze — Problem 3: It's Mooin' Time](https://usaco.org/index.php?page=viewproblem2&cpid=1445)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

Given a string with possibly one corrupted character, find every moo (three letters of the form a b b with a ≠ b) that could appear at least F times, and print them sorted.

## Approach

- Count the moos in the original string.
- For each position, remove the moos touching it, try all 26 letters there, add back the moos created and record every moo whose count reaches F, then restore the original counts.

## Complexity

- **Time:** O(26 · N)
- **Space:** O(N)

## Concepts

Brute Force with Incremental Updates, Hashing

## Files

- [`src/mooing.java`](src/mooing.java)

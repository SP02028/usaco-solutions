# FEB

**Source:** [USACO 2023 US Open Contest, Bronze — Problem 1: FEB](https://usaco.org/index.php?page=viewproblem2&cpid=1323)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

A string of B, E and F (unknown) letters; excitement counts adjacent equal letters (BB or EE). List all possible excitement levels over every way to replace the F's.

## Approach

- Handle each block of F's between two known letters: its contribution ranges over values of a fixed parity between a minimum (0 or 1) and a maximum.
- F's at the start or end add freedom of one step. Combine the blocks: without end F's the possible values step by 2, otherwise by 1.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Case Analysis, Parity, Strings

## Files

- [`src/feb.java`](src/feb.java)

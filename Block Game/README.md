# Block Game

**Source:** [USACO 2016 December Contest, Bronze — Problem 2: Block Game](https://usaco.org/index.php?page=viewproblem2&cpid=664)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

There are N boards, each with two words, and each board may show either word. Find, for each letter a–z, the minimum number of blocks needed so every possible choice of faces can be spelled.

## Approach

- For each board, the worst case for a letter is the larger of its counts in the two words.
- Sum that maximum over all boards for every letter.

## Complexity

- **Time:** O(total word length)
- **Space:** O(26)

## Concepts

Counting, Simulation

## Files

- [`src/block.java`](src/block.java)

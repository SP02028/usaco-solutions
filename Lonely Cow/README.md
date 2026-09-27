# Lonely Photo

**Source:** [USACO 2021 December Contest, Bronze — Problem 1: Lonely Photo](https://usaco.org/index.php?page=viewproblem2&cpid=1155)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Count contiguous photos of at least 3 cows in which exactly one cow is of one breed (G or H), meaning a 'lonely' cow.

## Approach

- Scan the right end i and track the last two positions of each breed. The valid left ends form a range determined by those positions, so add its size in O(1) per step.

## Complexity

- **Time:** O(N)
- **Space:** O(1)

## Concepts

Counting, Two Pointers

## Files

- [`src/LC.java`](src/LC.java)

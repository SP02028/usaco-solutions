# High Card Wins

**Source:** [USACO 2015 December Contest, Silver — Problem 2: High Card Wins](https://usaco.org/index.php?page=viewproblem2&cpid=571)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 15 official USACO test cases.

## Problem

Bessie and Elsie split the cards 1..2N evenly, and Elsie's cards are known. In each round the higher card wins. Maximize Bessie's wins.

## Approach

- Bessie's cards are the complement of Elsie's. Sort both and greedily match each Elsie card with Bessie's smallest card that beats it, using two pointers.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Greedy, Two Pointers, Sorting

## Files

- [`src/HighCardWins.java`](src/HighCardWins.java)

## Notes

Uses USACO file I/O (`highcard.in` / `highcard.out`).

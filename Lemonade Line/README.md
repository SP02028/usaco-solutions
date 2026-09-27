# Lemonade Line

**Source:** [USACO 2018 US Open Contest, Silver — Problem 2: Lemonade Line](https://usaco.org/index.php?page=viewproblem2&cpid=835)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Each cow joins the lemonade line only if at most w_i cows are already in it. Choose the order of arrival to minimize the final line length.

## Approach

- Let cows with the largest thresholds arrive first. Pop cows from a max-heap while their threshold is at least the current line length; the answer is the number that joined.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Greedy, Priority Queue

## Files

- [`src/LL.java`](src/LL.java)

## Notes

Uses USACO file I/O (`lemonade.in` / `lemonade.out`).

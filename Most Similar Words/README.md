# Most Similar Words

**Source:** [Codeforces 1676C — Most Similar Words](https://codeforces.com/contest/1676/problem/C)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Among n words of length m, find the minimum total cost to make two words equal, where changing a letter by one position in the alphabet costs 1.

## Approach

- For every pair of words, sum |a_k − b_k| over positions and take the minimum.

## Complexity

- **Time:** O(n² · m) per test case
- **Space:** O(n · m)

## Concepts

Brute Force, Strings

## Files

- [`src/MSW.java`](src/MSW.java)

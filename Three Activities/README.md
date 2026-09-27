# Three Activities

**Source:** [Codeforces 1914D — Three Activities](https://codeforces.com/contest/1914/problem/D)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Choose three distinct days for skiing, a movie and board games, maximizing the total number of friends joining (each day has a count per activity).

## Approach

- Only the top 3 days of each activity can be part of an optimal answer. Try all 3·3·3 combinations with distinct days.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Brute Force over Candidates

## Files

- [`src/TA.java`](src/TA.java)

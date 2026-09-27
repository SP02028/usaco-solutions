# Yet Another Tournament

**Source:** [Codeforces 1783C — Yet Another Tournament](https://codeforces.com/contest/1783/problem/C)  
**Difficulty:** Codeforces rating 1700  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

You play n players (player i beats every lower-index player, and you beat player i by spending a_i time). With m time, minimize your final place.

## Approach

- Beat the cheapest opponents greedily; if you win k games, your place is n − k + 1 (in the code's form n + 1 − k).
- You can also swap your most expensive win for opponent k (who otherwise has k wins, one more than you) if the budget allows, which improves your place by one.

## Complexity

- **Time:** O(n log n) per test case
- **Space:** O(n)

## Concepts

Greedy, Sorting

## Files

- [`src/YAT.java`](src/YAT.java)

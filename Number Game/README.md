# Number Game

**Source:** [Codeforces 1370C — Number Game](https://codeforces.com/contest/1370/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 12 official Codeforces tests that are published in full.

## Problem

Ashishgup and FastestFinger play on n: divide by an odd divisor > 1 or subtract 1. The player who cannot move loses. Determine the winner with optimal play.

## Approach

- n = 1 loses and n = 2 wins. Odd n > 1 wins. For even n: a power of two loses, and n = 2·p with p an odd prime loses. Every other even n wins.

## Complexity

- **Time:** O(√n) per test case
- **Space:** O(1)

## Concepts

Game Theory, Number Theory

## Files

- [`src/NG.java`](src/NG.java)

# Suit and Tie

**Source:** [Codeforces 995B — Suit and Tie](https://codeforces.com/contest/995/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 18 official Codeforces tests that are published in full.

## Problem

2n people stand in a row as n couples. With adjacent swaps, make every couple stand next to each other, minimizing the number of swaps.

## Approach

- Greedily take the leftmost unpaired person and bubble their partner leftward until adjacent, counting swaps (the code processes couples from the right end symmetrically). This greedy is optimal.

## Complexity

- **Time:** O(n²)
- **Space:** O(n)

## Concepts

Greedy, Adjacent Swaps

## Files

- [`src/ST.java`](src/ST.java)

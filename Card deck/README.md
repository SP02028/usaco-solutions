# Card Deck

**Source:** [Codeforces 1492B — Card Deck](https://codeforces.com/contest/1492/problem/B)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A deck of n cards (a permutation, bottom to top) is moved to a new deck by repeatedly taking some top cards and placing them, in order, onto the new deck. Maximize the resulting deck's 'order', which is dominated by having large cards near the bottom.

## Approach

- Greedy: the largest card not yet moved should go next. Take the block from that card's position up to the current top, then move on to the next largest remaining value.
- Process values from n down to 1 using a position index and a moving 'current top' boundary.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Greedy, Permutations

## Files

- [`src/CD.java`](src/CD.java)

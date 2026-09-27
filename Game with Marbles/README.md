# Game with Marbles (Hard Version)

**Source:** [Codeforces 1914E2 — Game with Marbles (Hard Version)](https://codeforces.com/contest/1914/problem/E2)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Alice and Bob each hold a_i and b_i marbles of colour i. They alternately pick a colour with marbles left: the player loses one marble of that colour and the opponent loses all of theirs. Alice maximizes and Bob minimizes (Alice's total − Bob's total). Find the final score.

## Approach

- Choosing colour i swings the score by a_i + b_i relative to the other player choosing it, so both players pick colours in decreasing order of a_i + b_i.
- Alternate turns over that order: Alice gains a_i − 1, Bob contributes −(b_i − 1).

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Game Theory, Greedy, Sorting

## Files

- [`src/GWM.java`](src/GWM.java)

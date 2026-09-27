# Yet Another Card Deck

**Source:** [Codeforces 1511C — Yet Another Card Deck](https://codeforces.com/contest/1511/problem/C)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 6 official Codeforces tests that are published in full.

## Problem

A deck of n cards with colours; each query takes the topmost card of colour t, prints its position and moves it to the top.

## Approach

- Simulate with a list: find the first card of the queried colour, print its 1-based position, then move it to the front.

## Complexity

- **Time:** O(n · q)
- **Space:** O(n)

## Concepts

Simulation

## Files

- [`src/YACD.java`](src/YACD.java)

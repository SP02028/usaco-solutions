# USB vs. PS/2

**Source:** [Codeforces 762B — USB vs. PS/2](https://codeforces.com/contest/762/problem/B)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 33 official Codeforces tests that are published in full.

## Problem

Buy mice to equip as many computers as possible (USB-only, PS/2-only and computers that accept both), minimizing the cost among maximal choices.

## Approach

- Sort each mouse type by price. Give the cheapest USB mice to USB-only computers and the cheapest PS/2 mice to PS/2-only computers, then give the cheapest leftovers of either type to the dual computers.

## Complexity

- **Time:** O(m log m)
- **Space:** O(m)

## Concepts

Greedy, Sorting

## Files

- [`src/UP.java`](src/UP.java)

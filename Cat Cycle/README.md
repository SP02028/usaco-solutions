# Cat Cycle

**Source:** [Codeforces 1487B — Cat Cycle](https://codeforces.com/contest/1487/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Cat A moves around n spots in decreasing order and cat B in increasing order; if they collide, B skips ahead one spot. Find B's position at hour k.

## Approach

- For even n they never collide, so B is at spot k.
- For odd n they collide once every floor(n/2) hours, so B's position is (k − 1 + (k − 1) / floor(n/2)) mod n + 1.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Concepts

Math, Modular Arithmetic

## Files

- [`src/CC.java`](src/CC.java)

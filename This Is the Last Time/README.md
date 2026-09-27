# This Is the Last Time

**Source:** [Codeforces 2126D — This Is the Last Time](https://codeforces.com/contest/2126/problem/D)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

n casinos each have a range [l_i, r_i] and a payout real_i. You start with k coins and may play a casino (each at most once) only if your coins are in its range, after which you hold real_i coins. Maximize your final coins (This Is the Last Time).

## Approach

- Only increasing moves are useful. Repeatedly look at every casino whose range contains the current amount and jump to the best payout above it, until no casino improves the amount.

## Complexity

- **Time:** O(n · number of improvements) per test case (the casinos are sorted by l but scanned fully each round)
- **Space:** O(n)

## Concepts

Greedy, Simulation

## Files

- [`src/LastTime.java`](src/LastTime.java)

## Notes

The folder was named after a different Codeforces problem ("I Will Definitely Make It"); the code solves "This Is the Last Time" from the same round, so the folder has been renamed.

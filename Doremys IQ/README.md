# Doremy's IQ

**Source:** [Codeforces 1707A — Doremy's IQ](https://codeforces.com/contest/1707/problem/A)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Doremy has IQ q and n contests in order with difficulties a_i. Testing a contest harder than her current IQ lowers her IQ by 1, and she cannot test with IQ 0. Choose contests to maximize the number tested.

## Approach

- Process contests backwards with a counter of 'IQ lost so far' starting at 0.
- A contest with a_i ≤ counter can be tested for free. Otherwise test it and increment the counter while the counter is still below q, so IQ drops happen as late as possible.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Reverse Thinking

## Files

- [`src/DIQ.java`](src/DIQ.java)

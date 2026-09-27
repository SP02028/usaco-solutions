# Swapity Swap

**Source:** [USACO 2020 February Contest, Bronze — Problem 3: Swapity Swap](https://usaco.org/index.php?page=viewproblem2&cpid=1013)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

N cows are rearranged K times by reversing ranges [A1, A2] and then [B1, B2]. Output the final order.

## Approach

- Simulate until the arrangement returns to the original, recording every state; the process is periodic, so the answer is the state at index K mod period.

## Complexity

- **Time:** O(N · period)
- **Space:** O(N · period)

## Concepts

Simulation, Cycle Detection

## Files

- [`src/SS.java`](src/SS.java)

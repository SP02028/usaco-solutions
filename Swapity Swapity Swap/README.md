# Swapity Swapity Swap

**Source:** [USACO 2020 February Contest, Silver — Problem 1: Swapity Swapity Swap](https://usaco.org/index.php?page=viewproblem2&cpid=1014)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows undergo a sequence of M range reversals repeated K times (K up to 10⁹). Output the final order.

## Approach

- Apply the M reversals once to get a permutation, then decompose it into cycles. Each cow moves K steps along its cycle, i.e. (index + K) mod cycle length.

## Complexity

- **Time:** O(N · M + N)
- **Space:** O(N)

## Concepts

Permutation Cycles, Simulation

## Files

- [`src/SSS.java`](src/SSS.java)

# Cow Frisbee

**Source:** [USACO 2022 January Contest, Silver — Problem 2: Cow Frisbee](https://usaco.org/index.php?page=viewproblem2&cpid=1183)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

N cows of distinct heights stand in a line. Cows i < j can throw a frisbee to each other if every cow between them is shorter than both. Sum (j − i + 1) over all such pairs.

## Approach

- Use a monotonic decreasing stack. When cow i arrives, every shorter cow popped from the stack forms a valid pair with i, and the cow left on top (if any) also pairs with i.
- There are O(N) pairs, so summing their distances is linear.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Monotonic Stack

## Files

- [`src/CF.java`](src/CF.java)

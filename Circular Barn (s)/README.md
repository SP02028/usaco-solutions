# Circular Barn

**Source:** [USACO 2016 February Contest, Silver — Problem 1: Circular Barn](https://usaco.org/index.php?page=viewproblem2&cpid=618)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Circular barn with N rooms where r_i cows must end in room i. All cows enter through one door and walk clockwise, costing the square of the distance walked. Minimize the total energy.

## Approach

- Try each room as the last room filled. Fill rooms backwards, each time pulling a cow from the closest non-empty room before it and adding the squared distance.

## Complexity

- **Time:** O(N³) in the worst case
- **Space:** O(N)

## Concepts

Complete Search, Simulation

## Files

- [`src/CB.java`](src/CB.java)

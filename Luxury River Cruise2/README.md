# Luxury River Cruise

**Source:** [USACO 2013 US Open Contest, Silver — Problem 3: Luxury River Cruise](https://usaco.org/index.php?page=viewproblem2&cpid=284)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N ports each have a left and a right destination. A route of M L/R instructions is repeated K times starting at port 1. Find the final port.

## Approach

- Precompute next[i], the port reached after one full pass of the M instructions from port i.
- Apply next K times starting from port 1.

## Complexity

- **Time:** O(N · M + K)
- **Space:** O(N)

## Concepts

Functional Graphs, Simulation

## Files

- [`src/LRC.java`](src/LRC.java)

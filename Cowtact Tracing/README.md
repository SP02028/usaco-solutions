# Cowntact Tracing

**Source:** [USACO 2020 US Open Contest, Bronze — Problem 3: Cowntact Tracing](https://usaco.org/index.php?page=viewproblem2&cpid=1037)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

N cows and T handshakes at distinct times. A patient zero was infected and each infected cow spreads the disease during her first K handshakes. Given who is infected at the end, output the number of possible patient zeros and the minimum and maximum possible K ('Infinity' if unbounded).

## Approach

- Brute force every patient zero and every K from 0 to 251.
- Simulate the handshakes in time order, counting handshakes for infected cows, and check whether the final infected set matches.

## Complexity

- **Time:** O(N · T_max · (T_max + N))
- **Space:** O(N + T_max)

## Concepts

Complete Search, Simulation

## Files

- [`src/CT.java`](src/CT.java)

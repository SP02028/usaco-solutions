# Milk Exchange

**Source:** [USACO 2024 February Contest, Bronze — Problem 2: Milk Exchange](https://usaco.org/index.php?page=viewproblem2&cpid=1396)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases.

## Problem

N cows sit in a circle, each facing left or right, with bucket capacities. Every minute each cow passes 1 unit of milk to the cow it faces (milk above capacity is lost). Find the total milk remaining after M minutes.

## Approach

- Milk is only lost at 'RL' meeting points, where two cows face each other and their buckets overflow.
- For each such meeting point, the cows streaming into it from behind (a run of R's before, or a run of L's after) lose min(sum of their buckets, M).
- Subtract these losses from the total.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Simulation, Circular Arrays

## Files

- [`src/ME.java`](src/ME.java)

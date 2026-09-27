# Milk Factory

**Source:** [USACO 2019 US Open Contest, Bronze — Problem 2: Milk Factory](https://usaco.org/index.php?page=viewproblem2&cpid=940)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N stations are connected by one-way walkways forming a tree. Find the smallest station reachable from every other station, or −1.

## Approach

- In a tree with N − 1 directed edges, a station reachable from all others must have no outgoing walkway, and it is the answer only if exactly one station has out-degree 0.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Graphs, Degree Counting

## Files

- [`src/MF.java`](src/MF.java)

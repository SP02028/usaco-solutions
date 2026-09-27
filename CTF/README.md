# Closing the Farm

**Source:** [USACO 2016 US Open Contest, Silver — Problem 3: Closing the Farm](https://usaco.org/index.php?page=viewproblem2&cpid=644)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

A farm has N barns connected by M roads. Barns are closed one at a time in a given order. Before each closure (and at the start), report whether the open barns still form one connected component.

## Approach

- After each closure, run a DFS from an open barn over open barns only and check whether every open barn was reached.

## Complexity

- **Time:** O(N · (N + M))
- **Space:** O(N + M)

## Concepts

Graph Connectivity, DFS

## Files

- [`CTF.java`](CTF.java)

## Notes

The folder name is short for Closing the Farm.

# Barn Tree

**Source:** [USACO 2022 December Contest, Silver — Problem 1: Barn Tree](https://usaco.org/index.php?page=viewproblem2&cpid=1254)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 16 official USACO test cases, checked with a custom validator because more than one answer is accepted.

## Problem

A tree of N barns where each barn holds some hay; the total is divisible by N. An order moves any amount of hay along a single edge, provided the source barn has enough at that moment. Output a minimum-length sequence of orders that equalizes all barns.

## Approach

- Root the tree and compute each subtree's surplus (sum of h_i − average) with a DFS.
- A positive surplus means hay must go from the child up to its parent, a negative one means from the parent down to the child; each nonzero edge needs exactly one order.
- To make every order feasible, treat 'x must send before y can send' as a dependency graph and output orders in topological order (Kahn's algorithm).

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Trees, DFS, Subtree Sums, Topological Sort

## Files

- [`src/BT.java`](src/BT.java)

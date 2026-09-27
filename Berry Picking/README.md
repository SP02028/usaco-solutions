# Berry Picking

**Source:** [USACO 2020 January Contest, Silver — Problem 1: Berry Picking](https://usaco.org/index.php?page=viewproblem2&cpid=990)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

N trees have B_i berries and there are K baskets (K even). Each basket holds berries from one tree only. Elsie receives the K/2 fullest baskets and Bessie the rest. Maximize the berries Bessie gets.

## Approach

- Enumerate the size b of Elsie's smallest basket (1..max B_i).
- Count how many full baskets of size b can be formed. If there are at least K, Bessie gets b · K/2. If there are fewer than K/2, stop.
- Otherwise Bessie gets the remaining full baskets of size b plus the largest leftover remainders (tree size mod b) to fill her other baskets.

## Complexity

- **Time:** O(max B · N log N)
- **Space:** O(N)

## Concepts

Complete Search, Greedy, Sorting

## Files

- [`src/BP.java`](src/BP.java)

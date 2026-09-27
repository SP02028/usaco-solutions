# Milk Visits

**Source:** [USACO 2019 December Contest, Silver — Problem 3: Milk Visits](https://usaco.org/index.php?page=viewproblem2&cpid=968)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

A tree of farms, each with a Guernsey or Holstein cow. For each friend's path from a to b with a preferred breed, decide whether some farm on the path has that breed.

## Approach

- Union adjacent farms of the same breed with a DSU; each component is a single-breed region.
- If a and b are in the same component, the whole path is one breed, so check that breed. Otherwise the path contains both breeds.

## Complexity

- **Time:** O((N + M) α(N))
- **Space:** O(N)

## Concepts

Disjoint Set Union, Trees

## Files

- [`src/MV.java`](src/MV.java)

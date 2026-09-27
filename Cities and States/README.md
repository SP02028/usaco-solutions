# Cities and States

**Source:** [USACO 2016 December Contest, Silver — Problem 2: Cities and States](https://usaco.org/index.php?page=viewproblem2&cpid=667)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Each city has a name and a two-letter state code. Count unordered pairs of cities from different states where the first two letters of each city's name equal the other city's state code.

## Approach

- Map each city to the key (first two letters of name + state). For a city with key (c, s) and c ≠ s, the matching partners have key (s, c); count them with a HashMap while scanning.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Hashing, Counting

## Files

- [`src/CaS.java`](src/CaS.java)

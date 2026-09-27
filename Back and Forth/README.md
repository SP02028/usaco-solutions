# Back and Forth

**Source:** [USACO 2018 December Contest, Bronze — Problem 3: Back and Forth](https://usaco.org/index.php?page=viewproblem2&cpid=857)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Two barns each start with a 1000-gallon tank and ten buckets. On four alternating days, Farmer John carries one bucket's worth of milk from one barn to the other and leaves the bucket there. Count the distinct possible milk amounts in the first barn's tank after the fourth day.

## Approach

- Recursively try every bucket choice for each of the four days, moving the bucket to the other barn and adjusting both tanks.
- Collect the first tank's final value in a HashSet and output its size.

## Complexity

- **Time:** O(10 · 11 · 10 · 11)
- **Space:** O(number of distinct outcomes)

## Concepts

Complete Search, Recursion

## Files

- [`src/BaF.java`](src/BaF.java)

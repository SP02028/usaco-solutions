# Contaminated Milk

**Source:** [USACO 2015 December Contest, Bronze — Problem 3: Contaminated Milk](https://usaco.org/index.php?page=viewproblem2&cpid=569)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N people drink M milk types at known times, and S people got sick at known times. Exactly one milk is bad. Find the maximum number of people who might need medicine.

## Approach

- A milk is a candidate if every sick person drank it strictly before getting sick; intersect those milk lists.
- For each candidate, count everyone who drank it at any time, and output the maximum.

## Complexity

- **Time:** O(S · D + M · N · D)
- **Space:** O(N + D)

## Concepts

Simulation, Set Intersection

## Files

- [`src/ContaminatedMilk.java`](src/ContaminatedMilk.java)

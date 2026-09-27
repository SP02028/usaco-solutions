# Watching Mooloo

**Source:** [USACO 2023 February Contest, Bronze — Problem 3: Watching Mooloo](https://usaco.org/index.php?page=viewproblem2&cpid=1301)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Bessie watches Mooloo on N known days. A subscription of d consecutive days costs d + K. Minimize the total cost.

## Approach

- Going through the days in order, either extend the current subscription over the gap (cost = gap) or start a new one (cost K + 1). Take the cheaper option for every gap.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Greedy

## Files

- [`src/mooloo.java`](src/mooloo.java)

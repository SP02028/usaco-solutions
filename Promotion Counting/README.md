# Promotion Counting

**Source:** [USACO 2016 January Contest, Bronze — Problem 1: Promotion Counting](https://usaco.org/index.php?page=viewproblem2&cpid=591)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Given the USACO participant counts in each division before and after a contest, compute how many were promoted Bronze→Silver, Silver→Gold and Gold→Platinum.

## Approach

- Work down from Platinum: promotions into a division equal its net increase plus the promotions out of it.

## Complexity

- **Time:** O(1)
- **Space:** O(1)

## Concepts

Math, Implementation

## Files

- [`src/Main.java`](src/Main.java)

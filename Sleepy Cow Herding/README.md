# Sleepy Cow Herding

**Source:** [USACO 2019 February Contest, Silver — Problem 1: Sleepy Cow Herding](https://usaco.org/index.php?page=viewproblem2&cpid=918)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

N cows on a number line. In one move an endpoint cow jumps to an empty spot so that it is no longer an endpoint. Find the minimum and maximum number of moves to make the cows consecutive.

## Approach

- Minimum: slide a window of length N and count the cows already inside it; the answer is N − max. A special case (N−1 cows consecutive with a gap of more than 2 to the last cow) needs 2.
- Maximum: the total empty space minus the smaller of the two end gaps.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sliding Window, Case Analysis

## Files

- [`src/SCH.java`](src/SCH.java)

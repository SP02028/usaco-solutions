# Visits

**Source:** [USACO 2022 US Open Contest, Silver — Problem 1: Visits](https://usaco.org/index.php?page=viewproblem2&cpid=1230)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Each cow i will visit cow a_i and gain v_i moo when that cow is still home. Order the visits to maximize total moos.

## Approach

- In the functional graph i → a_i, each cycle must lose exactly one visit (the first cow to leave breaks the cycle), and every other visit can succeed.
- Detect every cycle with Floyd's algorithm and subtract the minimum v on it from the total.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Functional Graphs, Cycle Detection

## Files

- [`src/V.java`](src/V.java)

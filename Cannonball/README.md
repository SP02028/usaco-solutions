# Cannonball

**Source:** [USACO 2024 January Contest, Bronze — Problem 2: Cannonball](https://usaco.org/index.php?page=viewproblem2&cpid=1372)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

Bessie hops along N positions that are either jump pads (increase her power and reverse direction) or targets (broken if her power ≥ the target's value). Starting at position S with power 1 moving right, count the targets she breaks before leaving the line.

## Approach

- Simulate the hops, adding broken targets to a set.
- Stop after 3N steps: once her power is large enough the process either leaves the line or cycles without breaking new targets.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Simulation

## Files

- [`src/CBall.java`](src/CBall.java)

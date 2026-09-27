# Herdle

**Source:** [USACO 2022 January Contest, Bronze — Problem 1: Herdle](https://usaco.org/index.php?page=viewproblem2&cpid=1179)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

A 3×3 Wordle-style game with cow breeds: count green squares (correct letter in the correct place) and yellow squares (correct letter in the wrong place, respecting multiplicities).

## Approach

- Count the answer's letter frequencies. First count greens and consume their frequencies, then count yellows only while frequency remains.

## Complexity

- **Time:** O(9)
- **Space:** O(26)

## Concepts

Simulation, Counting

## Files

- [`src/h.java`](src/h.java)

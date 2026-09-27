# Reverse Engineering

**Source:** [USACO 2022 December Contest, Bronze — Problem 3: Reverse Engineering](https://usaco.org/index.php?page=viewproblem2&cpid=1253)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Elsie's program is a chain of 'if bit b = v return r' statements followed by 'else return r'. Given N inputs with their outputs, decide whether some such program is consistent (OK) or Elsie lied (LIE).

## Approach

- Repeatedly look for a bit position and value on which all remaining inputs with that value share the same output; such inputs can be handled by an if statement, so remove them.
- If eventually all inputs are removed the answer is OK; if no progress can be made, it is LIE.

## Complexity

- **Time:** O(N · M²)
- **Space:** O(N · M)

## Concepts

Greedy, Simulation

## Files

- [`src/RE.java`](src/RE.java)

# Nusret Gokce

**Source:** [Codeforces Gym 104114, problem N](https://codeforces.com/gym/104114/problem/N)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Adjust an array of heights so adjacent heights differ by at most d, only ever increasing values, and output the resulting array (minimal such heights).

## Approach

- Forward pass: raise a[i+1] to at least a[i] − d. Backward pass: raise a[i−1] to at least a[i] − d.
- Two passes enforce the constraint in both directions.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Greedy, Two-Pass Relaxation

## Files

- [`src/NG.java`](src/NG.java)

# Squares

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

For each k from 1 to n, compute the MEX of the values that are the maximum of some subarray of length k.

## Approach

- With monotonic stacks, find for each element the widest window in which it is the maximum; a value is the maximum of some length-k window iff its best window length is ≥ k.
- Process k from n down to 1, adding values whose window length equals k to a presence array, and advance a MEX pointer.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Monotonic Stack, MEX

## Files

- [`src/Main.java`](src/Main.java)

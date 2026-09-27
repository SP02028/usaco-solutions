# Mad MAD Sum

**Source:** [Codeforces 1990C — Mad MAD Sum](https://codeforces.com/contest/1990/problem/C)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Repeatedly replace every element with the MAD (maximum value appearing at least twice) of its prefix, summing the array each time until it becomes all zeros. Output the total sum.

## Approach

- After one or two applications the array becomes non-decreasing with every value repeated, and afterwards each step just shifts it right by one.
- Apply the transformation twice directly, then add the contribution of the shifting phase as a weighted sum Σ (n − i + 1)·a_i.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Observation, Simulation

## Files

- [`src/MMS.java`](src/MMS.java)

## Notes

The problem's official name is "Mad MAD Sum".

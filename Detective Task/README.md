# Detective Task

**Source:** [Codeforces 1675C — Detective Task](https://codeforces.com/contest/1675/problem/C)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 2 official Codeforces tests that are published in full.

## Problem

Friends visited a room in order; each answered whether the painting was there (1), not there (0), or doesn't remember (?). Exactly one person, the thief, may have lied. Count the possible thieves.

## Approach

- The thief must be at or after the last '1' and at or before the first '0'.
- Answer = firstZero − lastOne + 1, with firstZero defaulting to n−1 and lastOne to 0.

## Complexity

- **Time:** O(n)
- **Space:** O(1)

## Concepts

Observation, Strings

## Files

- [`src/DT.java`](src/DT.java)

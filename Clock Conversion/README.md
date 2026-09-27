# Clock Conversion

**Source:** [Codeforces 1950C — Clock Conversion](https://codeforces.com/contest/1950/problem/C)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Convert times from 24-hour format hh:mm to 12-hour format with AM/PM.

## Approach

- Case analysis on the hour: 00 → 12 AM, 01–11 → AM, 12 → PM, 13–23 → subtract 12 and print PM, keeping two-digit hours.

## Complexity

- **Time:** O(1) per test case
- **Space:** O(1)

## Concepts

Implementation, Strings

## Files

- [`src/Main.java`](src/Main.java)

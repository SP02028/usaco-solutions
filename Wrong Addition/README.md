# Wrong Addition

**Source:** [Codeforces 1619C — Wrong Addition](https://codeforces.com/contest/1619/problem/C)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

Tanya adds digit by digit without carrying, concatenating the digit sums. Given a and her result s, find b such that her addition of a and b gives s, or −1.

## Approach

- Process digits from the right. If s's digit is at least a's, b's digit is the difference; otherwise take two digits of s (which must form 10–19) and subtract. Leftover digits of a mean −1. Strip leading zeros.

## Complexity

- **Time:** O(digits) per test case
- **Space:** O(digits)

## Concepts

Digits, Simulation

## Files

- [`src/WA.java`](src/WA.java)

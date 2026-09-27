# a-Good String

**Source:** [Codeforces 1385D — a-Good String](https://codeforces.com/contest/1385/problem/D)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

A string of length 2^k is 'c-good' if it has length 1 and equals c, or one half consists entirely of c and the other half is (c+1)-good. Find the minimum number of character changes to make the string 'a'-good.

## Approach

- Divide and conquer: for a segment and target letter c, either make the left half all c and recurse on the right half with c+1, or vice versa.
- Cost of filling a half with c is the number of characters in it that are not c; return the smaller of the two options.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n log n) (substring copies)

## Concepts

Divide and Conquer, Recursion

## Files

- [`src/AGS.java`](src/AGS.java)

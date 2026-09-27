# GCD on a Blackboard

**Source:** [AtCoder ABC125 C — GCD on Blackboard](https://atcoder.jp/contests/abc125/tasks/abc125_c)  
**Verified:** ⚪ Not verified automatically: test data was not downloaded for this problem.

## Problem

Replace one of N numbers with any integer to maximize the gcd of all N numbers.

## Approach

- Replacing an element is the same as removing it, so compute prefix and suffix gcds and take the maximum of gcd(prefix[i−1], suffix[i+1]) over all i.

## Complexity

- **Time:** O(N log A)
- **Space:** O(N)

## Concepts

Prefix/Suffix GCD

## Files

- [`src/GCDOB.java`](src/GCDOB.java)

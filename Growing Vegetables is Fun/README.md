# Growing Vegetables is Fun

**Source:** [JOI 2021 Final Round (Japanese Olympiad in Informatics), Problem 1](https://oj.uz/problem/view/JOI21_ho_t1)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Given N plant heights, you may increase any contiguous range by 1 per operation. Find the minimum number of operations to make the sequence strictly increasing up to some peak and strictly decreasing after it.

## Approach

- left[i] = total increases needed so that the prefix up to i is strictly increasing (sum of max(0, a[j−1] − a[j] + 1)). right[i] is the same for the suffix to be strictly decreasing.
- Increases on both sides can share range operations, so the cost for peak i is max(left[i], right[i]); take the minimum over all peaks.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Prefix Sums, Greedy

## Files

- [`src/GVIF.java`](src/GVIF.java)

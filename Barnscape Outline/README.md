# Barnscape Outline

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

N buildings are given left to right, each with a coordinate and a height. Count the minimum number of rectangles needed to draw the skyline outline, where each rectangle can span consecutive positions at a fixed height.

## Approach

- Maintain a monotonic increasing stack of 'open' heights.
- When the height rises, push it; when it falls, pop every taller height (each popped height closes one rectangle) and push the new height if it is not already on top.
- The answer is the number of closed rectangles plus the heights remaining on the stack at the end; height 0 never needs a rectangle.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Monotonic Stack, Greedy

## Files

- [`src/BO.java`](src/BO.java)

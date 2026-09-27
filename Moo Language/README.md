# Moo Language

**Source:** [USACO 2023 US Open Contest, Bronze — Problem 2: Moo Language](https://usaco.org/index.php?page=viewproblem2&cpid=1324)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 16 official USACO test cases, checked with a custom validator because more than one answer is accepted.

## Problem

Build the text with the most words from a word bank (nouns, transitive/intransitive verbs, conjunctions), obeying Moo grammar with at most C commas and P periods.

## Approach

- Greedily form sentences: use type-2 sentences (noun, transitive verb, noun) while nouns allow, and type-1 (noun, intransitive verb) otherwise, up to P + min(P, conjunctions) sentences.
- Join pairs of sentences with conjunctions to save periods, and append extra nouns (each with a comma) to one type-2 sentence.
- Print the word count and the constructed text.

## Complexity

- **Time:** O(N) per test case
- **Space:** O(N)

## Concepts

Greedy, Constructive, Strings

## Files

- [`src/ML.java`](src/ML.java)

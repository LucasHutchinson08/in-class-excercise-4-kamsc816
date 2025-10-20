[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/U6_xl8FJ)
# In Class Excercise 4

## Assignment 1: Guessing Game

### Objective
Practice using loops, conditional statements, user input, and the Random class in Java.

### Description
Write a program that plays a number guessing game between the computer and the user.

- The computer will randomly select a secret number between 1 and 100 (inclusive)
- The user will try to guess the number
- After each guess, the program will tell the user whether the guess was:
  - Too high
  - Too low
  - Correct!
- The game should keep looping until the user correctly guesses the number

### Expected Output (example)
```
Welcome to the Guessing Game!
I'm thinking of a number between 1 and 100. 
Enter your guess: 50
Too low! Try again.
Enter your guess: 75
Too high! Try again.
Enter your guess: 63
You got it!
```

## Assignment 2: Shopping Cart

### Objective
Practice using for loops, user input, and calculations in Java.

### Description
Write a program that calculates the total cost of items in a shopping cart.

**Expected Output:**
```
How many items are you purchasing? 3
Price of item 1? 1.5
Price of item 2? 3.1
Price of item 3? 0.5
Your cart has 3 items with a total cost of $5.1
```

## Requirements

### Assignment 1 (Guessing Game) Required Components:
1. **Use a do...while loop** to repeat the guessing process
2. **Use a Random object** to generate the secret number
3. **Use Scanner** to get user input
4. **Provide feedback** after each guess (Too high, Too low, or Correct!)
5. **Count attempts** and display the total when the user wins

### Assignment 2 (Shopping Cart) Required Components:
1. **Use a for loop** to iterate through items
2. **Use Scanner** to get user input (number of items and prices)
3. **Use double** data type for prices (decimal numbers)
4. **Calculate total** by adding all item prices
5. **Display formatted output** with item count and total cost

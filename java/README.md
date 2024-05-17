Yatzy Refactor
==============

Overview
--------

This project involves refactoring the `Yatzy1` class and its corresponding test class `Yatzy1Test`. The refactor aims to improve code readability, reduce redundancy, enhance maintainability, and increase performance.

Changes in `Yatzy1` Class
-------------------------

### Generalized `scoreForValue` Method

- Created a single method for scoring any dice value to reduce redundancy.
- Replaced individual methods (`ones`, `twos`, `threes`) with a single method to handle any face value.

### Stream API

- Utilized the Stream API to sum values and count occurrences for better readability and performance.
- Replaced manual loops with stream operations.

### Helper Method `countDice`

- Extracted the dice counting logic into a helper method to avoid repetition.
- Centralized the logic for counting occurrences of each dice face in the `countDice` method.

### Consistent Naming

- Ensured consistent method and variable naming for clarity and better understanding.
- Adopted a unified naming convention across the class.

### Simplified Logic

- Simplified the logic for scoring methods such as pair, two pairs, three of a kind, four of a kind, small straight, large straight, and full house.
- Reduced complex conditions and loops into more straightforward and understandable code.

Changes in `Yatzy1Test` Class
-----------------------------

### Utilized `@BeforeEach`

- Used the `@BeforeEach` annotation to initialize common objects or variables.
- Reduced redundancy by setting up common test fixtures.

### Parameterized Tests

- Utilized parameterized tests for methods with similar patterns to reduce redundancy and improve readability.
- Grouped similar assertions logically using parameterized tests.

### Descriptive Assertion Messages

- Added descriptive messages to assertions to make the purpose and expected outcome clear.
- Improved readability and maintainability by providing context for each assertion.

### Grouped Assertions

- Grouped similar assertions logically to improve test readability and maintainability.
- Reduced redundancy by combining similar test cases into parameterized tests.

Summary
-------

The refactoring of the `Yatzy1` class and `Yatzy1Test` class focuses on improving code quality by reducing redundancy, enhancing readability, and ensuring maintainability. The use of modern Java features such as the Stream API and parameterized tests in JUnit helps achieve these goals, making the codebase more efficient and easier to understand.

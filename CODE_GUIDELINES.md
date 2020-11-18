# Code Guidelines
## Kotlin
Please follow the [Kotlin conventions](https://kotlinlang.org/docs/reference/coding-conventions.html).  
If the Code Guidelines and the official conventions clash, use the Kotlin conventions.  
It is highly recommended that you enable the style in your IDE.  

## General advice
When writing code, if shortening the code will make it longer, but making it longer will make it more readable, always go for the longer and more readable code. We don't write code for computers. We write it for humans.

### Specifics
#### Required
- Omit the types of variables when possible.
- Use `fun foo() = x` instead of `fun foo() { return x }`. If possible, omit the return type.
- Put a new line after any control flow statements, unless the control flow statement is a one liner.
- Put a new line before a return, unless the method is a one liner. However, one liner methods are discouraged.
- Put code in a lambda on a new line if it is over 1 line or is long.

#### Recommended
- Use `it` in lambda parameters when possible, unless the use of `it` makes the code more confusing.
- Enum constants should be in `THE_NAME` format.
- Prefer method references over lambdas.

#### Do not
- Do not use semicolons to use multiple statements on one line.
- Do not use string concatenation. Instead, use string templates.
- Do not use `\n` in strings. Instead, use multiline strings.

#### Refrain
- Refrain from trailing commas, except in enums.
- Refrain from using `init` blocks when the variable can be assigned in its declaration.
- Refrain from using `init` blocks or variable declaration + assign when the value is directly from a constructor. Instead, declare it in the constructor.

### Note
This document was last edited 2020-11-18 22:05:17 UTC (ISO 8601).
**Please check regularly to see if there are any changes.**

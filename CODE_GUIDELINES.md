# Code Guidelines
## Kotlin
Please follow the [Kotlin conventions](https://kotlinlang.org/docs/reference/coding-conventions.html). If the Code Guidelines and the official conventions clash, use the coventions.
It is highly recommended that you enable the style in your IDE.

## General advice
When writing code, if shortening the code will make it longer, but making it longer will make it more readable by other developers, always go for the longer and more readable code. We don't write code for computers. We write it for humans.

### Specifics
#### Required
- Omit the types of variables when possible.
- Use `fun foo() =` instead of `fun foo() {}`. If possible, omit the return type.
- Put a new line after any control flow statements, unless the control flow statement is a one liner.
- Put a new line before a return, unless it's a one liner.
- Put code in a lambda on a new line if it is over 1 line or is long.

#### Recommended
- Use `it` in lambda parameters when possible, unless the use of `it` makes the code more confusing.
- Enum constants should be in `THE_NAME` format.

#### Do not
- Do not use semicolons to use multiple statements on one line.
- Do not use string concatenation. Instead, use string templates.
- Do not use `\n` in strings. Instead, use multiline strings.

#### Refrain
- Refrain from trailing commas, except in enums.
- Refrain from using `init` blocks when the variable can be assigned in its declaration.
- Refrain from using `init` blocks or variable declaration + assign when the value is directly from a constructor. Instead, declare it in the constructor.

### Note
This document was last edited 2020-11-18 (ISO 8601).
**Please check regularly to see if there are any changes.**

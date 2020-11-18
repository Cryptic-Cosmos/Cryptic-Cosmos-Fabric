# Code Guidelines
## Kotlin
Please follow the [Kotlin conventions](https://kotlinlang.org/docs/reference/coding-conventions.html).
It is highly recommended that you enable the style in your IDE.

### Specifics
#### Required
- Put a new line after any control flow statements, unless the control flow statement is a one liner.
- Put a new line before a return.
- Put code in a lambda on a new line if it is over 1 line or is long.
#### Recommended
- Use `it` in lambda parameters when possible.
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

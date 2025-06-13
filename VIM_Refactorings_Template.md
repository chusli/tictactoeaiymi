# Info

This File is using <name your IDE> with the VIM Emulator <name the VIM Plugin>.
The Goal is to describe VIM Refactorings, that are useful for Developers.

Try to create Examples that don't have more then 14 VIM Refactoring Moves!
Code Snippet shouldn't be more then 10 Lines of Code.

# Examples

## Example-1

@
Delete the Word 'Damir'.

``` java
register("Damir");
```

| WHAT                | HOW                           |
|---------------------|-------------------------------|
| search for 'D'      | <kbd>/D</kbd><kbd>enter</kbd> |
| search next Finding | <kbd>n</kbd>                  |
| delete Word         | <kbd>dw</kbd>                 |

## Example-2

@
search and replace 'fiss' with 'fizz'

``` java
"""1, 2, Fizz, 4, Gagi, Fizz, 7, 8, Fizz, Gagi, 
11, Fizz, 13, 14, Fizz Gagi, 16, 17, Fizz, 19, 
Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, 
Fizz Buzz, 31, 32, Fizz, 34, Buzz, Fizz"""
```

| WHAT            | HOW        |
|-----------------|------------|
| command mode    | :          |
| replace         | %s         |
| search replace  | /fiss/fizz |
| modifier global | /g         |

## Example-3

@
Rename method

``` <Programming Language>
void main(String... args)
```

| WHAT                     | HOW                     |
|--------------------------|-------------------------|
| goto method              | /main(                  |
| rename (IntelliJ Hotkey) | Shift + F6              |
| type new name            | type <kbd>newName</kbd> |
| confirm                  | <kbd>Enter</kbd>        |

## Example-4

@
Move block (cut and paste block)

| WHAT          | HOW                                    |
|---------------|----------------------------------------|
| goto line 32  | <kbd>32</kbd><kbd>g</kbd><kbd>g</kbd>  |
| visual mode   | <kbd>v</kbd>                           |
| goto line 64  | <kbd>64</kbd><kbd>g</kbd><kbd>g</kbd>  |
| remove block  | <kbd>d</kbd>                           |
| goto line 128 | <kbd>128</kbd><kbd>g</kbd><kbd>g</kbd> |
| insert block  | <kbd>p</kbd>                           |

## Example-5

@
Inline Code

``` Python
name = get_user_name()
print(f"Hello, {name}")
```

| WHAT              | HOW                                     |
|-------------------|-----------------------------------------|
| Gehe zu           | /name =                                 |
| Bewege Cursor     | get_user_name()                         |
| Yank inner word   | <kbd>y</kbd><kbd>i</kbd><kbd>w</kbd>    |
| Gehe zu           | /print                                  |
| Bewege Cursor     | name                                    |
| Change inner word | <kbd>c</kbd><kbd>i</kbd><kbd>w</kbd>    |
| Insert yank       | <kbd>CTRL</kbd><kbd>r</kbd><kbd>"</kbd> |
| Gehe zu           | /name =                                 |
| löschen           | <kbd>dd</kbd>                           |

## Example-6

@
use macro to record and replay some key-sequences. example: add comment // at start of the nextd 4 lines

``` <Programming Language>
print("Hello")
print("Foo")
print("Bar")
print("Test1")
print("Test2")
```

| WHAT                                | HOW                                                  |
|-------------------------------------|------------------------------------------------------|
| move cursor where you want to start |                                                      |
| start record with 'q' for slot 'w'  | <kbd>qw</kbd>                                        |
| type macro                          | <kbd>i</kbd><kbd>//</kbd><kbd>ESC</kbd><kbd>j0</kbd> |
| end recording                       | <kbd>q</kbd>                                         |
| execute macro 4 times               | <kbd>4</kbd><kbd>@</kbd><kbd>w</kbd>                 |
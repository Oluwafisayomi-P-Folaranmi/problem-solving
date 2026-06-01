A SIDEWAYS TRIANGLE

1. We can reduce the problem. Also, by doing what we know first,
   we can write a program that is similar to this. We can write out a rectangle,
   length 7, using loops.

```
#
##
###
####
###
##
#
```

But before then, let's write out a row. The following Java code writes
out a row of seven (7) "#" using loop:

```java
for (int row = 1; line <= 7; line++) {
    System.out.println("#");
}
```

Then, we proceed to writing out the whole rectangle. The following code writes
out the rectangle, length 7 and width 4:

```java
for (int row = 1; row <= 7; row++) {
    for (int line = 1; line <= 4; line++) {
        System.out.print("#");
    }
    System.out.println();
}
```

```
####
####
####
####
####
####
####
```

2. From here, we can visualise the problem and see if we can
   generate a set of possible actions/operations/patterns exhibited by the problem
   which we can make use of:

```
#
##
###
####
###
##
#
```

| row | line | sum | difference | pattern |
| --- | ---- | --- | ---------- | ------------------------
|  1  |  1   |  2  |  0         |  4 - row = gives the space '3'
|  2  |  2   |  4  |  0         |  4 - row = gives the space '2'
|  3  |  3   |  6  |  0         |  4 - row = gives the space '1'
|  4  |  4   |  8  |  0         |  4 - row = gives the space '0'
|  5  |  3   |  8  |  2         |  4 - row = gives the space '1' if result is made absolute
|  6  |  2   |  8  |  4         |  4 - row = gives the space '2' if result is made absolute
|  7  |  1   |  8  |  5         |  4 - row = gives the space '3' if result is made absolute

From here, we can use this insight in the program.
When we put the algebraic relation into the output statement, as in:

```java
for (int row = 1; row <= 7; row++) {
    for (int line = 1; line <= 4; line++) {
        System.out.print(Math.abs(4 - row));
    }
    System.out.println();
}
```

we have the output:

```
3333
2222
1111
0000
1111
2222
3333
```

We can proceed from here and manipulate the space to get our result. Let's try out the
following code:

```java
for (int row = 1; row <= 7; row++) {
    for (int line = 1; line <= 4 - Math.abs(4 - row); line++) {
        System.out.print(Math.abs(4 - row));
    }
    System.out.println();
}
```

And then finally:

```java
for (int row = 1; row <= 7; row++) {
    for (int line = 1; line <= 4 - Math.abs(4 - row); line++) {
        System.out.print("#");
    }
    System.out.println();
}
```

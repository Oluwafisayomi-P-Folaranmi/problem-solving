# **Singly Linked-List**

## **`addFirst()` in a Singly Linked List**

The `addFirst()` operation inserts a new node at the beginning of the linked list.

Before insertion:

```text
head ──► A ──► B ──► C ──► null
tail ──────────────────────▲
```

After inserting `N` at the front:

```text
head ──► N ──► A ──► B ──► C ──► null
tail ─────────────────────────────▲
```

The operation takes **O(1)** time because only a few references are changed.

## **Memory State Explanation**

| State       | Stack (References)                                                                      | Heap (Objects)                                             | Explanation                                                                                                                                                   |
| :---------- | :-------------------------------------------------------------------------------------- | :--------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **State 1** | `head` points to `A`.<br>`tail` points to `C`.<br>`n` points to the newly created node. | Existing nodes `A → B → C → null`.<br>New node `N → null`. | A new node is created. At this point, it is completely independent of the list. The list itself is unchanged.                                                 |
| **State 2** | `head` still points to `A`.<br>`tail` still points to `C`.<br>`n` points to `N`.        | `N → A → B → C → null`                                     | The new node's `next` reference is updated to point to the current first node (`head`). The original list is still intact because `head` has not yet changed. |
| **State 3** | `head` now points to `N`.<br>`tail` still points to `C`.<br>`n` is no longer needed.    | `N → A → B → C → null`                                     | The `head` reference is updated to point to the new node. `N` becomes the first node of the list. The insertion is complete.                                  |

---

## Special Case: Empty List

Before insertion:

```text
head ─► null
tail ─► null
```

After insertion:

```text
head ─► N ─► null
tail ─────▲
```

---

### Memory State Explanation

| State       | Stack (References)                                              | Heap (Objects) | Explanation                                                                                                            |
| :---------- | :-------------------------------------------------------------- | :------------- | :--------------------------------------------------------------------------------------------------------------------- |
| **State 1** | `head = null`.<br>`tail = null`.<br>`n` points to the new node. | `N → null`     | A new node is created. Since the list is empty, there are no existing nodes to connect to.                             |
| **State 2** | `head` points to `N`.<br>`tail = null`.                         | `N → null`     | The new node becomes the first node by assigning `head = n`.                                                           |
| **State 3** | `head` points to `N`.<br>`tail` also points to `N`.             | `N → null`     | Since the list contains only one node, both `head` and `tail` must reference the same node. The insertion is complete. |

---

# Java Implementation

```java
public void addFirst(E e) {

    Node<E> n = new Node<>(e, null);

    if (isEmpty()) {
        head = n;
        tail = n;
    } else {
        n.setNext(head);
        head = n;
    }

    size++;
}
```

---

## Line-by-Line Explanation

| Code                               | Explanation                                                                                                                                |
| :--------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------- |
| `Node<E> n = new Node<>(e, null);` | Creates a new node that stores the element. Initially, its `next` reference is `null`, so it is not yet connected to the list. *(State 1)* |
| `if (isEmpty())`                   | Checks whether the list contains any nodes.                                                                                                |
| `head = n;`                        | In an empty list, the new node becomes the first node. *(Special Case – State 2)*                                                          |
| `tail = n;`                        | Since there is only one node, it is both the first and the last node. *(Special Case – State 3)*                                           |
| `n.setNext(head);`                 | In a non-empty list, the new node is linked to the current first node. *(State 2)*                                                         |
| `head = n;`                        | The `head` reference is updated so that the new node becomes the first node. *(State 3)*                                                   |
| `size++;`                          | Increments the number of nodes in the list after the insertion is complete.                                                                |

---

### Why the Order Matters

The order of the two statements below is critical:

```java
n.setNext(head);
head = n;
```

If you write:

```java
head = n;
n.setNext(head);
```

then `head` already points to `n`, so the second statement makes the new node point to **itself**, disconnecting the original list:

```text
head
 │
 ▼
 N
 ▲
 └───┘

A → B → C
```

The original nodes become unreachable from `head`, effectively breaking the list.

For this reason, the new node must first be linked to the existing first node, and **only then** should `head` be updated to reference the new node. This ordering preserves the original list while making the new node its first element.

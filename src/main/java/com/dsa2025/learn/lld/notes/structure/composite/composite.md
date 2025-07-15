## Composite Design Pattern

UML diagram of Composite

![Schema UML diagram of Composite design pattern](Composite-1.png)
![Design of App using Composite design pattern](Composite-2.png)

# Composite Pattern – README

> **Definition**  
> The **Composite** is a structural design pattern that lets you treat
> individual objects and compositions of objects **uniformly**, making it easy
> to build and work with **tree-like structures**.

---

## 📌 Applicability

| Use When… | Why |
|-----------|-----|
| Your domain naturally forms a **hierarchy** (file systems, GUI widgets, organization charts, etc.). | Composite models the hierarchy directly. |
| Client code should **ignore the difference** between simple and complex elements. | A single interface covers both. |

---

## 🏗️ Core Roles

| Role | Responsibility |
|------|----------------|
| **Component (interface)** | Declares common operations (e.g., `operation()`). Optionally declares `add/remove/getChild` for uniform child management. |
| **Leaf** | Implements `Component`; represents terminal nodes (no children). |
| **Composite** | Implements `Component`; stores children (both `Leaf` and `Composite`) and delegates work to them, often recursively. |

---

## 🛠️ Implementation Steps

1. **Model the hierarchy**: divide objects into *leaves* and *composites*.
2. **Create the `Component` interface** with methods meaningful to both kinds.
3. **Implement `Leaf` classes** that perform work directly.
4. **Implement a `Composite` class** that holds a collection of `Component` references and delegates operations to them.
5. **Refactor clients** to depend only on `Component`, allowing them to treat the whole tree uniformly.

---

## ✅ Pros

* **Uniform traversal** – same API for simple and complex nodes.
* **Recursive elegance** – operations propagate naturally through the tree.
* **Open/Closed Principle** – new node types can be introduced without changing existing code.

## ⚠️ Cons

* **Interface bloat** – if leaves inherit child-management methods they don’t use, Interface Segregation may be violated.
* Designing a truly **common interface** can be tricky when leaf and composite responsibilities diverge.

---

## 📝 Key Takeaways

* Composite turns **nested hierarchies** into polymorphic structures: invoke an
  operation on the root, and the entire tree responds appropriately.
* Decide early whether to expose child-management methods on the common
  interface (maximum transparency) or only on `Composite` (better segregation).

---

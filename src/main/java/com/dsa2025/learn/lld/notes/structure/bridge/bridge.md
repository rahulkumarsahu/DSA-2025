## Bridge Design Pattern

UML diagram of Bridge

![Schema UML diagram of Bridge design pattern](Bridge-1.png)
![Design of App using Bridge design pattern](Bridge-2.png)

# Bridge Pattern – README

> **Definition**  
> The **Bridge** is a structural design pattern that splits a large class—or
> a set of closely related classes—into two independent hierarchies:
> **Abstraction** and **Implementation**.  This decoupling lets you vary them
> **independently** and swap implementations at runtime.

---

## 📌 Applicability

| Use When… | Why It Helps |
|-----------|--------------|
| A monolithic class has **multiple independent variations** (e.g., shapes that must render on different GUIs; data stores for different databases). | Bridge separates each variation into its own hierarchy, reducing class bloat. |
| You need to extend a class along **orthogonal dimensions** (abstraction ⇄ implementation). | Each hierarchy grows without touching the other. |
| Implementations must be **switchable at runtime**. | Just inject a new implementation object into the abstraction. |

---

## 🏗️ Core Roles

| Role | Responsibility |
|------|----------------|
| **Abstraction** | Declares high-level operations needed by the client. Holds a reference to an `Implementation`. |
| **Refined Abstraction** | Optional subclasses that add or override high-level logic. |
| **Implementation (interface)** | Defines low-level, platform-specific operations used by the abstraction. |
| **Concrete Implementation** | Platform-specific classes that perform real work (database, OS API, renderer, etc.). |

---

## 🛠️ Implementation Steps

1. **Identify orthogonal dimensions** (e.g., *device ↔ protocol*, *UI ↔ platform*).
2. **Create the `Abstraction` interface/class** exposing operations needed by clients.
3. **Define an `Implementation` interface** containing all low-level operations the abstraction might require.
4. **Implement concrete classes** for every platform or detail level (`MySQLImpl`, `PostgresImpl`, `SVGRenderer`, `CanvasRenderer`, …).
5. **Add an `Implementation` reference** as a field inside `Abstraction`; delegate work to it.
6. **Optionally add `RefinedAbstraction` subclasses** for alternate high-level behaviors.
7. **Inject** the desired implementation object into the abstraction (via constructor or setter) in client code.
8. **Use** the abstraction exclusively—clients never touch implementation classes directly.

---

## ✅ Pros

* **Platform-independent abstractions** – same high-level code works with any implementation.
* **Loose coupling** – client sees only abstractions.
* **Open/Closed Principle** – add new abstractions **or** implementations without modifying existing code.
* **Single Responsibility** – abstraction handles high-level logic; implementation handles platform specifics.

## ⚠️ Cons

* **Extra layers** – may over-engineer a simple, cohesive class.
* More files to navigate (two hierarchies instead of one).

---

## 📝 Key Takeaways

* Bridge ≠ Strategy: both swap implementations, but **Bridge** separates
  _abstraction_ from _implementation_ for long-term evolution, whereas
  **Strategy** encapsulates interchangeable _algorithms_.
* Choose Bridge when you have **two dimensions** that must vary independently
  and foresee many combinations (e.g., `Shape × Renderer`, `UI Control × OS`).
* Start simple; introduce Bridge only when a class begins to groan under the
  weight of multiple unrelated variations.

---

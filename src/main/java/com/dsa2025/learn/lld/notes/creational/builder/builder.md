# Builder Design Pattern

UML diagram of builder

![Schema UML diagram of adapter design pattern](builder-1.png)
![Design of Navigation App using builder design pattern](builder-2.png)

# 🏗️ Builder Pattern

## 📌 Problem

Creating complex objects with many parts can lead to:
- **Huge constructors** with too many parameters (most of them unused).
- **Too many subclasses** for every object variation.
- **Messy and duplicated code** scattered across the app.

---

## ✅ Solution

The **Builder Pattern** helps by moving the construction logic to a separate **builder** class.

- It builds the object **step by step**.
- You only call the steps you **actually need**, making the code clean and flexible.
- Different builders can create different versions of the object using the same steps.
    - For example: a **wooden house**, **stone castle**, or **gold palace**.

---

## 🧱 Optional: Director

You can use a **Director** class to define the exact order of building steps.

- It separates **what to build** (builder) from **how to build it** (director).
- The client just assigns a builder to the director and gets the final product.
- This keeps construction reusable and easy to manage.

---

## ✅ Benefits

- Avoids telescoping constructors.
- Clean and readable object creation.
- Supports various product configurations.
- Better separation of concerns.

Builder Design Pattern
✅ Applicability
Use the Builder pattern when:


You want to avoid telescoping constructors with many optional parameters.

You need to create different representations of a product using the same construction process.

You are building composite trees or complex objects step-by-step.


Creating such overloaded constructors becomes unmanageable. The Builder pattern provides a clean alternative.

🛠️ How to Implement
Identify the steps to construct all versions of the product.

Define a base Builder interface declaring these steps.

Create concrete builders that implement the interface for specific product variants.

Add a method to retrieve the result after construction.

If the result type varies, this method should be in the concrete builder, not the interface.

Optionally, create a Director class to control the construction sequence.

🧭 Structure
Client --> Director --> Builder Interface --> Concrete Builders --> Product
Director: Defines the order of building steps.

Builder Interface: Declares all build steps.

Concrete Builder: Implements steps for a specific product.

Product: The final constructed object.

🎯 Benefits
Construct objects step-by-step with full control.

Defer or customize steps without breaking the end result.

Reuse logic for constructing different product variants.

Follows Single Responsibility Principle by separating construction logic from product logic.

⚠️ Trade-offs
Increases overall complexity due to multiple additional classes (builders, director, product variations).
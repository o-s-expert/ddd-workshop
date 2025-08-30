# 2 Tactic Patterns

To see the diagrams properly, please open them in [Mermaid Live Editor](https://mermaid-js.github.io/mermaid-live-editor).

Or you can use the following link: https://github.com/o-s-expert/ddd-workshop/blob/main/guides/docs/01_context_mapping.md

## Entity – Identity Matters

> An object defined by a unique identity that persists over time, even if its attributes change.

```mermaid
classDiagram
  class Customer {
    +id : UUID
    -name : String
    -email : String
    +changeEmail(newEmail) : void
  }
```


## Value Object – Essence over Identity

> An immutable object defined solely by its attributes; equality is based on value rather than identity.

```mermaid
classDiagram
  class Email {
    -address : String
    +Email(address)
  }

  class Money {
    -amount : decimal
    -currency : String
    +Money(amount, currency)
    +add(other: Money) : Money
  }
```

## Aggregate – Consistency Boundary

> A cluster of entities and value objects treated as a single unit, with a root entity ensuring business rules and consistency.

```mermaid
classDiagram
  class Order {
    <<aggregate root>>
    +id : UUID
    -status : OrderStatus
    -items : List~OrderItem~
    +addItem(product: Product, quantity: int) : void
    +changeItemQuantity(product: Product, quantity: int) : void
    +removeItem(product: Product) : void
    +confirm() : void
    -enforceInvariants() : void
  }

  class OrderItem {
    <<entity>>
    +id : UUID
    -product : Product
    -quantity : int
  }

  class Product {
    <<entity>>
    +id : UUID
    +name : String
  }

  class OrderStatus

  Order "1" o-- "1..*" OrderItem
  OrderItem --> Product
  Order --> OrderStatus

```

## Repository – Gateway to Aggregates

> An abstraction that provides controlled access to aggregates, handling persistence while keeping the domain pure.

```mermaid
classDiagram
    class Order {
<<aggregate root>>
+id : UUID
}

class OrderRepository {
<<interface>>
+save(order: Order) : void
+findById(id: UUID) : Order?
+delete(id: UUID) : void
+findByCustomer(customerId: UUID) : List~Order~
}

OrderRepository --> Order : returns/manages

```


## Factory – Controlled Creation

> A mechanism that encapsulates complex creation logic, ensuring invariants are satisfied when building aggregates or entities.

```mermaid

```

## Domain Service – Logic Without a Home

> Encapsulates domain behavior that does not naturally belong to an entity or value object, but is still part of the core domain.

```mermaid

```

## Domain Event – Something Happened

> Represents a significant occurrence in the domain, capturing a past fact and enabling communication across the system.

```mermaid

```


# Understanding Context Mapping

## Shared Kernel- A Common Ground

> Two contexts share a part of the model, requiring close coordination and trust between teams.

```mermaid
flowchart LR
  subgraph C1["Context A"]
    A1[Domain Model A]
  end

  subgraph C2["Context B"]
    B1[Domain Model B]
  end

  SK[(Shared Kernel<br/>Shared Model Part)]

  A1 --- SK
  B1 --- SK
```

## Customer–Supplier

> The downstream (customer) depends on the upstream (supplier) and can influence its priorities or features.

```mermaid
flowchart LR
    subgraph U["Upstream (Supplier)"]
        U1[Payments Service]
    end

    subgraph D["Downstream (Customer)"]
        D1[Orders Service]
    end

    U1 -- "Provides functionality" --> D1
    D1 -- "Influences requirements" --> U1
```

## Conformist

> The downstream has no influence and must fully adapt to the upstream model as it is.


```mermaid
flowchart LR
  subgraph U["Upstream Context"]
    U1[Payments]
  end

  PL[(Published Model / Contract)]

  subgraph D["Downstream Context"]
    D1[Orders]
  end

  U1 -- "Owns & defines" --> PL
  D1 -- "Conforms to" --> PL
  D1 -. "No influence on Upstream" .- U1
  D1 -. "No influence on Downstream" .- U1
  ```

## Anticorruption Layer

> The downstream isolates its domain by translating the upstream model, preventing external concepts from leaking in.


```mermaid
flowchart LR
subgraph U["Upstream Context"]
U1[Payments]
end

subgraph D["Downstream Context"]
D1[Orders]
end

ACL["`Anticorruption Layer`"]

U1 -- "Provides Model" --> ACL
ACL -- "Translates & Protects" --> D1
D1 -. "Own domain language preserved" .- D1
 ```

## Published Language

> Teams agree on a shared, well-defined communication language or schema to integrate smoothly.
 
```mermaid
flowchart LR
  subgraph U["Upstream Context"]
    U1[Payments Supplier]
  end

  PL[(Published Language<br/>OpenAPI / Avro / JSON Schema)]

  subgraph D["Downstream Contexts"]
    D1[Orders Customer]
    D2[Analytics]
    D3[Billing Reconciliation]
  end

  U1 -- Publishes --> PL
  D1 -- Consumes --> PL
  D2 -- Consumes --> PL
  D3 -- Consumes --> PL
```

## Separate Ways

> Contexts remain isolated, evolving independently without integration.

```mermaid
flowchart LR
  subgraph A["Context A"]
    A1[Payments]
  end

  subgraph B["Context B"]
    B1[Orders]
  end

  A -. "No integration" .- B
```

## Open Host Service

> The upstream provides a well-defined API or protocol that multiple downstreams can consume without tight coupling.

```mermaid
flowchart LR
  subgraph U["Upstream Context"]
    U1[Payments Service]
  end

  OHS[(Open Host Service<br/>Public API / Protocol)]

  subgraph D["Downstream Contexts"]
    D1[Orders]
    D2[Analytics]
  end

  U1 -- "Exposes API" --> OHS
  D1 -- "Consumes API" --> OHS
  D2 -- "Consumes API" --> OHS
```
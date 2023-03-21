# 3rd Action, the Movie: Establishing Boundaries and Context Mapping  

In this exercise you will see how the concepts of **bounded context** and **context mapping** can be applied in real life. 

!!! note "Roll up your sleeves, and get to action!"

    It's time to practice what you have learned and get your hands. Roll up your sleeves and let's get to action!

## Exercise goals

WIP

## Scenario

**Business Goal:** As a moviegoer, I want to go to the movie theater, buy a ticket, maybe get some snacks and drinks, and watch the chosen movie.

--- 
## Practicing Domain Storytelling
 
Use [Egon](https://egon.io/) to map this story while you explore it using Domain Storytelling.

The outcome of this practice should be a **diagram** representation of the **Movie** use case and its respective **java service**.

### Getting Started

!!! tip "TIP: Shedding light on solutions"

    ... 

1. Using your browser, access [Egon.io](http://egon.io)
2. Import the diagram located under `ddd-workshop-labs/storytelling/03-movies.dst`
3. Complete the domain by exploring the use case, asking questions or discussing with other attendees;

Make sure you complete the following tasks:

- [ ] Some actions are certainly missing in this diagram. Which actions should be mapped for the `moviegoer` that are not represented? 
- [ ] Describe in the diagram, the `sequence order` of each action. 
    - _To change a group sequence, you can double-click on the association arrow and set your input data;_
- [ ] Are there optional items? Add a `text annotation` to highlight this characteristic.
    ![03-text-annotation-icon.png](images/03-text-annotation-icon.png)



Once you're satisfied with the domain map, and you feel like it covers the use case story accordingly, you are ready to
start designing you Java service.
 
Our next step is to practice the modeling of the application, matching the implementation with the domain exploration details.

---

## From Story to Code: the Movie service


1. In the `ddd-workshop-labs` folder, locate and open the project `03-movies` using your chosen Java IDE;
2. Open the test class `expert.os.workshop.ddd.cinema.OrderTest`; 
3. Now evaluate the following items:
   4. Is this test is validating the user story previously described? If not, what are your ideas to adjust it?
   5. In this unit test, we can notice the following validation:
   
```java linenums="1"
    Movie movie = new Movie("Matrix", Year.of(1999)); //(1)
    Product ticket = new Ticket(movie, Money.of(10, currency)); //(2)
    Product popcorn = new Food("popcorn", Money.of(15, currency));  //(3)
    Order order = Order.of(moviegoer);    //(4)
    
    order.add(ticket); 
    order.add(popcorn); //(5)!
    
    MonetaryAmount total = order.total(); //(6)
    Assertions.assertThat(total) 
            .isEqualTo(Money.of(25, currency)); //(7)
```

1. Creates the `Movie` Matrix, from 1999;
2. The `Ticket` for this `Movie` costs $10;
3. The `Food` available to be bought is a popcorn, and it costs $15;
4. The `Moviegoer` creates a new order; 
5. This person's `Order` includes a `Ticket` for Matrix and his snack, the popcorn.
6. The `Moviegoer` needs to pay for the total amount of this order;
7. Assures the total `Order` cost is compliant to the business rules; 

The test validates one of the paths of our storytelling: a user should be able to acquire movie theater tickets
and snacks in order to watch the movie.

Due to the domain exploration, you probably feel comfortable when reading this text - a result of 
the usage of ubiquitous language across business conversations and the technology scope.

Now, before finishing this project's implementation, navigate through the project and notice the following details:

1. The products sold by this movie theater are defined by the `Interface` named `Product`. 
```java
public record Food (String name, MonetaryAmount price) implements Product {}
public record Ticket (Movie movie, MonetaryAmount price) implements Product { }
```
2. Entities such as `Moviegoer` and `Movie` are mapped with `org.jmolecules.ddd.annotation.@Entity`.   

3. Because we're relying on OOP abstraction, in the `Order` class, adding a new product is really simple to write, understand and maintain:

```java linenums="1"
public void add(Product product) { //(1)
    Objects.requireNonNull(product,"product is required");
    this.products.add(product);
}
```
    
1. If new products are made available, the impacts on the `Order` class should be minimal to none;

----
Your task is to wrap up the implementation of this project. #wip



# 6th Action Java, NoSQL and DDD: Abstracting business away from your db solution    

In this exercise you will learn how to abstract your domain data from the technical implementation details related to 
database persistence, most specifically, non-relational persistence storage with NoSQL
.
In this exercise you can validate and practice your knowledge of the following concepts:

* A pure Java implementation of non-relational database persistence 
* Dev experience when using NoSQL databases with Java; 
* Jakarta NoSQL; 
* Implicit and constant usage of CDI;

!!! note "Roll up your sleeves, and get to action!"

    It's time to practice what you have learned and get your hands. Roll up your sleeves and let's get to action!

## Exercise goals

- [ ] Connect a Java application to a MongoDB database
- [ ] Map a persistable Java `Entity`;
- Manage data:
    - [ ] Insert 
    - [ ] Search
    - [ ] Delete

## Scenario

**Business Goal:** Manage book's data (Insert/Search/Delete) using a document type NoSQL database solution and Java.  

## Get ready

1. **Code:** 
    
    Make sure you have the latest version of the `ddd-workshop-labs` project. Using a terminal, open the `ddd-workshop-labs` folder and run the command below:  
    ```shell
    git pull origin main
    ```

2. **Docker:**

    we'll need a MongoDB instance. Docker simplifies the DB setup. Make sure docker is running;
    !!! info "If you don't have Docker installer yet, you can get it at: https://www.docker.com/"

3. *Database:*

    Start a MongoDB container with the following command:  
    ```shell
    docker run -d --name mongodb-instance -p 27017:27017 mongo
    ```

### Jakarta NoSQL: Getting Started with Java and NoSQL

You will now be working with the project `06-jnosql`. It brings a basic Java project structure with previously configured
CDI dependencies (weld).  

#### Add Jakarta NoSQL to your project 

1. The first step is to open your `pom.xml` file and, within the `<dependencies>` section, add the JNoSQL dependency:  

```xml linenums="44"
<!--        Add JNoSQL dependency-->
<dependency>
    <groupId>org.eclipse.jnosql.mapping</groupId>
    <artifactId>jnosql-mongodb-extension</artifactId>
    <version>${jnosql.version}</version>
</dependency>

```

#### Configuring the database connection

When using MicroProfile Config, the properties are mainly placed in the `src/main/resources/microprofile-config.properties` file. 
This is also where we'll add our database configurations.

1. Open the file `src/main/resources/microprofile-config.properties`
2. Uncomment and fill in our MongoDB database name and host:  
```properties
jnosql.document.database=library
jnosql.mongodb.host=localhost:27017
```

#### Mapping Entities

Mapping our persistable object is very straightforward, especially when bringing **Java Records** to the scene:

1. Create a new class file: `expert.os.workshop.ddd.jnosql.Book`;
```java
public record Book() { }
```
2. Set the attributes of the class, String `isbn`, String `title`, and `Year` year; Configure these attributes as column with the `jakarta.nosql.@Column` annotation; 
```java
public record Book(@Id String isbn, @Column("title") String title, @Column("year") Year year) {
```

3. Configure this as a `jakarta.nosql.@Entity`. Here's an example of how it should look like at the end:
```java linenums="1"
package expert.os.workshop.ddd.jnosql;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;

@Entity
public record Book(@Id String isbn, @Column("title") String title, @Column("year") Year year) {
}
```

!!! success "Congratulations! At this point you have configured the database and finished creating the entity we will store in MongoDB!"

#### Managing Data with Jakarta NoSQL 

Now, let's get some data in our MongoDB instance!  

!!! note "We will rely on the power of CDI to instantiate a `DocumentTemplate` for us. We can do that by using the `SeContainer` directly or `@Inject` depending on your application definitions."

Let's ask CDI to create an instance, or return an existing instance, of `DocumentTemplate`.

This is the object we will use to manage our data in MongoDB.

1. Using your IDE, open your class `expert.os.workshop.ddd.jnosql.App`
2. **Create a new Book**, that we'll use to explore some data management APIs;
    ````java linenums="30"
    /**
     * TODO: Create a book instance: `effective`
     * */
    Book(UUID.randomUUID().toString(), "Effective Java", Year.of(2012));
    ````
2. Inside the `try...catch` block, ask CDI for an **instance** of `DocumentTemplate`; 
     ```java  linenums="35"
        /**
         * TODO: Use CDI container to create `template`, an instance of `jakarta.nosql.document.DocumentTemplate`
         * */
        DocumentTemplate template = container.select(DocumentTemplate.class).get();
     ```
2. **Insert the `book`** in our database using the `template`: 
     ```java  linenums="38"
            /**
             * TODO: Using the `template` instance, use the method `insert` to save the `effective` book
             * */
            template.insert(effective);   
     ```
3. **Search** for books with name "effective" using the template `select` Fluent API, and print it on the command line:
     ```java  linenums="43"
            /**
             * TODO: Try out the fluent API for searching data.
             * Use the `template.select` method to search for books where title equals to "Effective Java");
             * Store the results in a `List<Book> books;
             * Print out the result of the search:  System.out.println("These are the books founds: " + books);
             * */
            List<Book> books = template.select(Book.class).where("title").eq("Effective Java")
                    .result();
            System.out.println("[DDD_IN_ACTION] Searching all books with title Effective Java: " + books);   
     ```
   
4. Using your IDE, execute the `App` class' `main` method and observe the outputs. At this point if all is right, you should be able to find the following logs in your console: 
    ```shell
    Mar 22, 2023 11:51:06 AM org.eclipse.jnosql.mapping.document.spi.DocumentExtension onAfterBeanDiscovery
    INFO: Processing repositories as a Document implementation: []
    Mar 22, 2023 11:51:06 AM org.jboss.weld.environment.se.WeldContainer fireContainerInitializedEvent
    INFO: WELD-ENV-002003: Weld SE container dc1de60f-2680-41ba-b928-ea7847aab678 initialized
    Mar 22, 2023 11:51:06 AM com.mongodb.internal.diagnostics.logging.Loggers shouldUseSLF4J
    WARNING: SLF4J not found on the classpath.  Logging is disabled for the 'org.mongodb.driver' component
    
    [DDD_IN_ACTION] Searching all books with title Effective Java: [Book[isbn=735b545a-e004-4716-a80c-81e7efc7a722, title=Effective Java, year=2012], Book[isbn=6c134ecf-e3c7-4de4-a0ef-e3bfd8d0a856, title=Effective Java, year=2012]]
    
    Mar 22, 2023 11:51:06 AM org.jboss.weld.environment.se.WeldContainer shutdown
    INFO: WELD-ENV-002001: Weld SE container dc1de60f-2680-41ba-b928-ea7847aab678 shut down
    ```
2. **Delete** every instance of `Book.class` with name `Effective Java`:
     ```java  linenums="53"
            /**
             * TODO: Delete
             * Using the `template`, use the method `delete` to delete instances of `Book.class` where the `title`
             * is equals to `Effective Java`.
             * Remind to invoke ".execute();" method to finalize the command;
             * */
            template.delete(Book.class).where("title").eq("Effective Java").execute();   
     ```
3. Search again and check the output: 
     ```java  linenums="61"
            /**
             * TODO: Search and List
             * Use the `template.select` method to search and print the result like you have done previously;
             * */
            System.out.println("[DDD_IN_ACTION] Searching again after deleting books: " + template.select(Book.class).where("title").eq("Effective Java").result()); 
     ```   

!!! NOTE "Notice we don't need to have **any** type of MongoDB related code, thanks to Jakarta NoSQL."

#### Testing the integration

If you run the application and observe a log such as the one below, you'll successfully implemented a Java solution with MongoDB persistence!

````shell
Mar 22, 2023 11:58:46 AM org.eclipse.jnosql.mapping.document.spi.DocumentExtension onAfterBeanDiscovery
INFO: Processing Document extension: 0 databases crud 0 found
Mar 22, 2023 11:58:46 AM org.eclipse.jnosql.mapping.document.spi.DocumentExtension onAfterBeanDiscovery
INFO: Processing repositories as a Document implementation: []
Mar 22, 2023 11:58:46 AM org.jboss.weld.environment.se.WeldContainer fireContainerInitializedEvent
INFO: WELD-ENV-002003: Weld SE container e0b071e7-f20f-400b-884c-3f8b2a6635f8 initialized
Mar 22, 2023 11:58:46 AM com.mongodb.internal.diagnostics.logging.Loggers shouldUseSLF4J
WARNING: SLF4J not found on the classpath.  Logging is disabled for the 'org.mongodb.driver' component

[DDD_IN_ACTION] Searching all books with title Effective Java: [Book[isbn=7eb9d1f4-df0e-44eb-97c3-896a7a80495c, title=Effective Java, year=2012]]
[DDD_IN_ACTION] Searching again after deleting books: []

Mar 22, 2023 11:58:46 AM org.jboss.weld.environment.se.WeldContainer shutdown
INFO: WELD-ENV-002001: Weld SE container e0b071e7-f20f-400b-884c-3f8b2a6635f8 shut down
````

----
## Congratulations!

:white_check_mark: Congratulations, you've done a great job so far! 

Keep it up, there's a bit more to come. :smile: Enjoy!



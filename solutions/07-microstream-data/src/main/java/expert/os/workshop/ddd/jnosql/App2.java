/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package expert.os.workshop.ddd.jnosql;


import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.nosql.Template;

import java.time.Year;
import java.util.List;
import java.util.UUID;


public class App2 {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Book effective = new Book(UUID.randomUUID().toString(), "Effective Java", Year.of(2012));
            Library library = container.select(Library.class).get();
            library.save(effective);

            List<Book> books = library.findByTitle("Effective Java");
            System.out.println("Entity found: " + books );
            System.out.println("The size: " + books.size());


            library.deleteByTitle("Effective Java");
            System.out.println("Entity found after delete: " + library.findByTitle("Effective Java"));
        }
    }

    private App2() {
    }
}

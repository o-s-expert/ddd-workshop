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
import jakarta.nosql.document.DocumentTemplate;

import java.time.Year;
import java.util.List;
import java.util.Random;


public class App {


    public static void main(String[] args) {

        Random random = new Random();
        long id = random.nextLong();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            Book effective = new Book("1231", "Effective Java", Year.of(2012));
            DocumentTemplate template = container.select(DocumentTemplate.class).get();
            template.insert(effective);

            List<Book> books = template.select(Book.class).where("where").eq("Effective Java")
                    .result();
            System.out.println("Entity found: " + books);

        }
    }

    private App() {
    }
}

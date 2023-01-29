package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@ApplicationScoped //has one instance per application
public class BookRepository {

    @ConfigProperty(name = "books.genre" , defaultValue = "Sci-fi")
    String genre;

    @Inject
    BookRepository repository;

    @Inject
    Logger logger;
    @GET
    public List<Book> getAllBooks() {
        logger.info("Return all books");
        return List.of(
                new Book(1,"Understanding Quarkus","Aymuos",2020,genre),
                new Book(2,"Practising Quarkus","Aymuos",2020,genre),
                new Book(3,"Effective Quarkus","Aymuos",2020,genre),
                new Book(4,"Kal bhi Quarkus","Aymuos",2020,genre)

        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBook(){
        logger.info("Returns count of books");
        return repository.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Returns details of book with given id ");
        return repository.getAllBooks().stream().filter(book -> book.id==id).findFirst();
    }
}
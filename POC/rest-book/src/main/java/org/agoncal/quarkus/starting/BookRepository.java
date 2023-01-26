package org.agoncal.quarkus.starting;

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

    @Inject
    BookRepository repository;

    @Inject
    Logger logger;
    @GET
    public List<Book> getAllBooks() {
        logger.info("Return all books");
        return repository.getAllBooks();
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
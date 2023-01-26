package org.agoncal.quarkus.starting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1,"Understanding Quarkus","CJ",2020,"IT"),
                new Book(2,"Understanding Quarkus","CJ",2020,"IT"),
                new Book(3,"Understanding Quarkus","CJ",2020,"IT"),
                new Book(4,"Understanding Quarkus","CJ",2020,"IT"),
                new Book(5,"Understanding Quarkus","CJ",2020,"IT")


        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBook(){
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id==id).findFirst();
    }
}
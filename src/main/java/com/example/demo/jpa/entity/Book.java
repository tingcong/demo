package com.example.demo.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by hutingcong on 2017/9/29.
 */
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = -4219748865445480414L;
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID") })
    private Set<Author> authors;

    public Book() {
        super();
    }

    public Book(String name) {
        super();
        this.name = name;
    }

    public Book(String name, Set<Author> authors) {
        super();
        this.name = name;
        this.authors = authors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Book [id=%s, name=%s, authors=%s]", id, name, authors);
    }
}

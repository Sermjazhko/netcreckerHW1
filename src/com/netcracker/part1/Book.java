package com.netcracker.part1;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[" +
                "name='" + name +
                ", authors={" + Arrays.toString(authors) +
                "}, price=" + price +
                ", qty=" + qty +
                ']';
    }

    public String getAuthorNames(){
        String authorsNames = new String();
        for(Author auth:authors)
            authorsNames +=  auth.getName() + ", ";
        return authorsNames;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;

        if (authors.length != book.authors.length) return false;
        int count = 0;
        for(int i = 0; i< authors.length; i++)
            for (int j =0; j<authors.length; j++)
                if (authors[i].equals(book.authors[j]))
                    count++;
        if (count!=authors.length) return false;

        return Double.compare(book.price, price) == 0 && qty == book.qty && this.name.equals( book.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long t = Double.doubleToLongBits(price);

        result = 31*result + name.hashCode();
        result = 31*result + (int)(t ^ (t >>> 32));
        result = 31*result + qty;

        for (Author author: authors)
            result = 31*result + author.hashCode();

        return result;
    }
}

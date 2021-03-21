package com.springboot.springboot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
   private long id;
   private String name;
   private String Author;
   private List<Meta> meta;

    public Book (long id, String name, String author) {
        this.id = id;
        this.name = name;
        Author = author;
        meta = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return Author;
    }
   public void addMeta(Meta metainfo){
        meta.add(metainfo);
   }

    public List<Meta> getMeta() {
        return meta;
    }

}


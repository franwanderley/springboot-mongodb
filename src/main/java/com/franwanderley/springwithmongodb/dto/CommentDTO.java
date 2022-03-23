package com.franwanderley.springwithmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
   private static final long serialVersionUID = 1L;

   private String name;
   private Date date; 
   private AuthorDTO author;
   
   public CommentDTO(String name, Date date, AuthorDTO author) {
      this.name = name;
      this.date = date;
      this.author = author;
   }
   public CommentDTO() {
   }

   public String getName() {
      return name;
   }
   public AuthorDTO getAuthor() {
      return author;
   }
   public void setAuthor(AuthorDTO author) {
      this.author = author;
   }
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
   public void setName(String name) {
      this.name = name;
   }
}

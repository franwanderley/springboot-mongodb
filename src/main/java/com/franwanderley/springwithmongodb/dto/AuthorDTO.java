package com.franwanderley.springwithmongodb.dto;

import java.io.Serializable;

import com.franwanderley.springwithmongodb.model.User;

public class AuthorDTO implements Serializable {
   private static final long serialVersionUID = 1L;
   private String id;
   private String name;

   public AuthorDTO(User user) {
      this.setId(user.getId());
      this.setName(user.getName());
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
}

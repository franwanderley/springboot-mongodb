package com.franwanderley.springwithmongodb.dto;

import java.io.Serializable;

import com.franwanderley.springwithmongodb.model.User;

public class UserDTO implements Serializable {
   private static final long serialVersionUID = 1L;

   private String id;
   private String email;
   private String name;

   public UserDTO(User user) {
      this.id = user.getId();
      this.email = user.getEmail();
      this.name = user.getName();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public UserDTO() {
   }
}

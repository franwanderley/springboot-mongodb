package com.franwanderley.springwithmongodb.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import com.franwanderley.springwithmongodb.service.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

   @ExceptionHandler(ObjectNotFoundException.class)
   public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
      HttpStatus status  = HttpStatus.NOT_FOUND;
      StandardError err = new StandardError(
         System.currentTimeMillis(),
         status.value(), 
         "Não Encontrado", 
         e.getMessage(),
         req.getRequestURI()
      );
      return ResponseEntity.status(status).body(err);
   }
}

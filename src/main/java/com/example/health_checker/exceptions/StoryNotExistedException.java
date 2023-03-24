package com.example.health_checker.exceptions;

import java.util.function.Supplier;

public class StoryNotExistedException extends RuntimeException  {

    public StoryNotExistedException(String message){
        super(message);
    }

}

package com.ritesh.insightdocs.exception;

public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(String msg){
            super(msg);
        }
}
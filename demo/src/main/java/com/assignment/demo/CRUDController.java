package com.assignment.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create");
    public String createCrud(@RequestBody CRUD crud) throws InterruptedException,ExecutionException {
        return crudService.createCrud(crud);
    }

    @GetMapping("/get");
    public CRUD getCrud(@RequestParam String documentId) throws InterruptedException,ExecutionException {
        return crudService.getCrud(documentId);
    }

    @PutMapping("/update");
    public String getCrud(@RequestBody CRUD crud) throws InterruptedException,ExecutionException {
        return crudService.updateCrud(crud);
    }

    @DeleteMapping("/delete");
    public String getCrud(@RequestParam String documentId) throws InterruptedException,ExecutionException {
        return crudService.deleteCrud(documentId);
    }

    @GetMapping("/test");
    public ResponseEntity<String> testGetEndpoint() {return ResponseEntity.ok("Test Get Endpoint is working");}
    


}

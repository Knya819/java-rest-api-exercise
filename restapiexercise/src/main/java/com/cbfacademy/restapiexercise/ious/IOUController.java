package com.cbfacademy.restapiexercise.ious;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;



@RestController
@RequestMapping(path = "api/ious")
public class IOUController {
    //service class is injected as a dependency
    private final IOUService iouService;

    @Autowired
    public IOUController(IOUService iouService){
        this.iouService = iouService;
    }

    @GetMapping("/{id}")
    public IOU getIOU(@PathVariable UUID id){

    }

  

}

package com.cbfacademy.restapiexercise.ious;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.List;




@RestController
@RequestMapping(path = "api/ious")
public class IOUController {
    //service class is injected as a dependency
    private final IOUService iouService;

    @Autowired
    public IOUController(IOUService iouService){
        this.iouService = iouService;
    }

    @GetMapping(produces = "application/json")
    public List<IOU> getAllIOUs(@RequestParam(required = false) String borrower){
        if (borrower != null && !borrower.isEmpty()){
            return iouService.getIOUsByBorrower(borrower);
        }else{
        return iouService.getAllIOUs();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public IOU getIOU(@PathVariable UUID id){
       return iouService.getIOU(id);
    }

    @PostMapping (produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public IOU createIou(@RequestBody IOU iou){
     //   IOU createdIOU = iouService.createIOU(iou);
        return iouService.createIOU(iou);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public IOU updatedIOU (@PathVariable UUID id, @RequestBody IOU updatedIOU){
        return iouService.updateIOU(id, updatedIOU);
    }

    @DeleteMapping("/{id}")
    public void deleteIOU(@PathVariable UUID id){
       iouService.deleteIOU(id);
    }
}

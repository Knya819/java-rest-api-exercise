package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

    private final IOUService iouService;

    public IOUController(IOUService iouService) {
        this.iouService = iouService;
    }

    @GetMapping
    public ResponseEntity<List<IOU>> getIOUs(@RequestParam(required = false) String borrower) {
        List<IOU> ious = iouService.getAllIOUs();
        return new ResponseEntity<>(ious, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IOU> getIOUById(@PathVariable UUID id) {
        try {
            IOU iou = iouService.getIOU(id);
            return new ResponseEntity<>(iou, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IOU> createIOU(@RequestBody IOU iou) {
        try {
            IOU createdIOU = iouService.createIOU(iou);
            return new ResponseEntity<>(createdIOU, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<IOU> updateIOU(@PathVariable UUID id, @RequestBody IOU iou) {
        try {
            IOU updatedIOU = iouService.updateIOU(id, iou);
            return new ResponseEntity<>(updatedIOU, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIOU(@PathVariable UUID id) {
        try {
            iouService.deleteIOU(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
    }

    @GetMapping("/high")
    public ResponseEntity<List<IOU>> getHighValueIOUs() {
        List<IOU> highValueIOUs = iouService.getHighValueIOUs();
        return ResponseEntity.ok(highValueIOUs);
    }

    @GetMapping("/low")
    public ResponseEntity<List<IOU>> getLowValueIOUs() {
        List<IOU> lowValueIOUs = iouService.getLowValueIOUs();
        return ResponseEntity.ok(lowValueIOUs);
    }
}

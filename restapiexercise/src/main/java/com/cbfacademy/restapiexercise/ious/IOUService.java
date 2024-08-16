package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
//import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class IOUService {
    private final IOURepository iouRepository;

    public IOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    // Retrieve all IOUs from the repository
    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
    }

    // Retrieve a specific IOU by its ID
    public IOU getIOU(UUID id) throws NoSuchElementException {
        return iouRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("IOU not found with id: " + id));
    }

    // Create a new IOU
    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        // Ensure the IOU object is valid before saving
        if (iou.getBorrower() == null || iou.getLender() == null || iou.getAmount() == null || iou.getDateTime() == null) {
            throw new IllegalArgumentException("Invalid IOU data provided");
        }
        return iouRepository.save(iou);
    }

    // Update an existing IOU by its ID
    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException {
        IOU existingIOU = iouRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("IOU not found with id: " + id));
            
        // Save the updated IOU
        return iouRepository.save(existingIOU);
    }

    // Delete an IOU by its ID
    public void deleteIOU(UUID id) throws NoSuchElementException {
        if (!iouRepository.existsById(id)) {
            throw new NoSuchElementException("IOU not found with id: " + id);
        }
        iouRepository.deleteById(id);
    }

      // New method to get IOUs by borrower
    public List<IOU> getIOUsByBorrower(String borrower) {
        return iouRepository.findByBorrower(borrower);
    }

    // New method to get high value IOUs
    public List<IOU> getHighValueIOUs() {
        return iouRepository.findHighValueIOUs();
    }

    // Method to get IOUs with values below or equal to the average
    public List<IOU> getLowValueIOUs() {
        return iouRepository.findLowValueIOUs();
    }
}

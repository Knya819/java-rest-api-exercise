package com.cbfacademy.restapiexercise.ious;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.NoSuchElementException;
import java.util.List;

@Service
public class IOUService {
    private final IOURepository iouRepository;

    public IOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    public List<IOU> getIOUsByBorrower(String borrower) {
        return iouRepository.findByBorrower(borrower);
    }

    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
    }

    public IOU getIOU(UUID id) throws NoSuchElementException {
        return iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException("IOU not found with id: " + id));
    }

    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        return iouRepository.save(iou);
    }

    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException {
        IOU existingIOU = getIOU(id);
        existingIOU.setBorrower(updatedIOU.getBorrower());
        existingIOU.setLender(updatedIOU.getLender());
        existingIOU.setAmount(updatedIOU.getAmount());
        existingIOU.setDateTime(updatedIOU.getDateTime());

        return iouRepository.save(existingIOU);
    }

    public void deleteIOU(UUID id) throws NoSuchElementException {
        if (!iouRepository.existsById(id)) {
            throw new NoSuchElementException("IOU not found with id: " + id);
        }
        iouRepository.deleteById(id);
    }
}

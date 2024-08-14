package com.cbfacademy.restapiexercise.ious;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.NoSuchElementException;
import java.util.List;


@Service
public class IOUService {
    private final IOURepository iouRepository;

    public IOUService(IOURepository iouRepository){
        this.iouRepository =iouRepository;
    }

    public List<IOU> getAllIOUs(){
        return iouRepository.findAll();
    }
    public IOU getIOU(UUID id) throws NoSuchElementException{
        return (IOU) iouRepository;

    }
    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException{
        return iou;

    }
    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException{
        return getIOU(null);

    }
    public void deleteIOU(UUID id){

    }
}

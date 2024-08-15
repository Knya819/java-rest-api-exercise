package com.cbfacademy.restapiexercise.ious;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.UUID;

@Repository
public interface IOURepository extends ListCrudRepository<IOU, UUID>{
    List<IOU> findByBorrower(String borrower);

}

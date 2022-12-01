package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Orders;

import dmacc.beans.Customer;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

}

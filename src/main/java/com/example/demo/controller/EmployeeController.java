package com.example.demo.controller;

import com.example.demo.message.request.EmployeeForm;
import com.example.demo.message.response.ResponseMessage;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

//    C1
//    @GetMapping("/findAll")
//    public List<EmployeeEntity> getAll(){
//        System.err.println("Get all employee!!");
//        return employeeRepository.findAll();
//    }

    //    C2
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeEntity>> getAll() {
        System.err.println("get All");
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //    insert employee
    @PostMapping("/register")
    public ResponseEntity registerEmployee(@RequestBody EmployeeForm employeeForm) {
        if (employeeRepository.existsByUserName(employeeForm.getUserName())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (employeeRepository.existsByEmail(employeeForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating employee's account
        EmployeeEntity employee = new EmployeeEntity(employeeForm.getFirstname(),
                employeeForm.getLastname(), employeeForm.getMiddlename(), employeeForm.getUserName(), employeeForm.getPassword(),
                employeeForm.getRole(), employeeForm.getDob(), employeeForm.isGender(), employeeForm.getPhone(),
                employeeForm.getEmail(), employeeForm.getType(), employeeForm.getPersonalID(), employeeForm.getAddress(),
                employeeForm.getEducation(), employeeForm.getSchool(), employeeForm.getFaculty(), employeeForm.getCourse(),
                employeeForm.getTimejoin(), employeeForm.isStatus());


//        EmployeeEntity employee =new EmployeeEntity(employeeForm.getUserName());

        employeeRepository.save(employee);

        return new ResponseEntity(new ResponseMessage("Employee registered successfully!"), HttpStatus.OK);
    }

    //update user information
//    @Modifying
//    @Query("update User u set u.active = false where u.lastLoginDate < :date")


    //thêm ("id") cạnh @PathVariable cũng được
//    @PostMapping("/getById/{id}")
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<EmployeeEntity> findById(@PathVariable Long id) {
//        System.err.println("Find by ID!");
//        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
//        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
//    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeEntity> findById(@PathVariable("id") String id){
        System.err.println("get by ID");
        //convert string to Long
        Long idd = Long.valueOf(id);
        EmployeeEntity employee =  employeeRepository.findByIdd(idd);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @GetMapping("/getByAddress/{address}")
    public ResponseEntity<List<EmployeeEntity>> findByAddress(@PathVariable("address") String address){
//        if (!employeeRepository.existsByAddress(address)) {
//            return new ResponseEntity(new ResponseMessage("Fail -> Address not found"),
//                    HttpStatus.BAD_REQUEST);
//        }
        System.err.println("get by address");
        List<EmployeeEntity> employees = employeeRepository.findByAddressLike("%"+address+"%");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //Descending order by id
    @GetMapping("/sortByIdDesc")
    public ResponseEntity<List<EmployeeEntity>> sortByIdDesc(){
        List<EmployeeEntity> employees = employeeRepository.findAllByOrderByIdDesc();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    //Descending order by last name
    @GetMapping("/sortByNameDesc")
    public ResponseEntity<List<EmployeeEntity>> sortByNameDesc(){
        List<EmployeeEntity> employees = employeeRepository.finAllByOrderByNameDesc();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
}

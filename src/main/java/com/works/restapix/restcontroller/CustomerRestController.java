package com.works.restapix.restcontroller;


import com.works.restapix.dto.CustomerDto;
import com.works.restapix.entities.Customer;
import com.works.restapix.utils.RestEnum;
import com.works.restapix.utils.Util;
import io.swagger.annotations.Api;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RequestMapping("/customer")
@RestController
@Api(value="Customer Rest Service")
public class CustomerRestController {

  final CustomerDto customerDtos;

  public CustomerRestController(CustomerDto customerDtos) {
    this.customerDtos = customerDtos;


  }


    @PostMapping("/customerAdd")
    public Map<RestEnum,Object> customerAdd(@RequestBody @Valid Customer customer, BindingResult bResult){
      Map<RestEnum,Object> hm =new LinkedHashMap<>();
      if ( bResult.hasErrors() ) {
      hm.put(RestEnum.status,"failed");
      hm.put(RestEnum.message,errors(bResult));
      }else {
        customerDtos.saveAndUpdatex(customer);
      }
      return hm;
    }


    @GetMapping("/delete/{index}")
    public Map<RestEnum,Object> deleted(@PathVariable String index){

      return customerDtos.delete(index) ;
    }

  @GetMapping("/findSingleCustomer/{index}")
public Map<RestEnum,Object> singleCustomer(@PathVariable String index){


   return customerDtos.findSingleCustomer(index);
  }

  @GetMapping("/keyword/{index}")
  public Map<RestEnum,Object> searchCustomer(@PathVariable String index) {


    return customerDtos.searchKeyword(index);
  }

  @GetMapping("/listAll")

  public Map<RestEnum,Object> listAllCustomer() {

    return customerDtos.listAll();
  }

  @GetMapping("/listPagable/{startPage}/{pageSize}")
  public Map<RestEnum,Object> listAllCustomerPagable(@PathVariable String startPage,@PathVariable String pageSize) {
int startP=Integer.parseInt(startPage);
int pSize=Integer.parseInt(pageSize);
    return customerDtos.listPageable(startP,pSize);
  }


    public List<Map<String, String>> errors(BindingResult bResult) {
        List<Map<String, String>> ls = new LinkedList<>();

        bResult.getAllErrors().forEach( error -> {
            String fieldName = ( (FieldError) error ).getField();
            String fieldMessage = error.getDefaultMessage();

            Map<String,String> erhm = new HashMap<>();
            erhm.put("fieldName", fieldName);
            erhm.put("fieldMessage", fieldMessage);
            ls.add(erhm);
        });

        return ls;
    }

}

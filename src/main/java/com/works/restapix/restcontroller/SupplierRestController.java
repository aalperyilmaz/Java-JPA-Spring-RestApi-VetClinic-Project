package com.works.restapix.restcontroller;

import com.works.restapix.dto.SupplierDto;
import com.works.restapix.entities.Suppliers;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/supplier")
@Api(value="Supplier Rest Service")
public class SupplierRestController {
    final SupplierDto supplierDto;

    public SupplierRestController(SupplierDto supplierDto) {
        this.supplierDto = supplierDto;
    }

    @PostMapping("/addOrUpdate")
    public Map<RestEnum,Object> addAndUpdate(@RequestBody Suppliers suppliers){

return  supplierDto.SupplierAddUpdate(suppliers);
    }


@GetMapping("/singleSupplier/{index}")
public Map<RestEnum,Object> findsingleSupllier(@PathVariable String index){

       return supplierDto.SupplierfindId(index) ;
}


@GetMapping("/delete/{index}")
public Map<RestEnum,Object> deleteSuppllier(@PathVariable String index){

        return supplierDto.Supplierdelete(index);
}





}

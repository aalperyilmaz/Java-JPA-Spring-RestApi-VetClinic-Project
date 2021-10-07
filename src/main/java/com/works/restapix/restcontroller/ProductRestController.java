package com.works.restapix.restcontroller;

import com.works.restapix.dto.ProductDto;
import com.works.restapix.entities.Product;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
@Api(value="Product Rest Service")
public class ProductRestController {
    final ProductDto productDto;

    public ProductRestController(ProductDto productDto) {
        this.productDto = productDto;
    }


    @PostMapping("/add")
    public Map<RestEnum,Object> productAdd(@RequestBody Product product){


        return  productDto.saveProduct(product);
    }



    @PostMapping("/update")
    public Map<RestEnum,Object> updateAdd(@RequestBody Product product){


        return  productDto.updateProduct(product);
    }


    @GetMapping("/listAll")
    public Map<RestEnum,Object> listAll(){


        return  productDto.listAllProduct();
    }

    @GetMapping("/snglproduct/{index}")
    public Map<RestEnum,Object> singleproduct(@PathVariable String index){


        return  productDto.singleProduct(index);
    }

    @GetMapping("/delete/{index}")
    public Map<RestEnum,Object> deleteProduct(@PathVariable String index){


        return  productDto.deleteProduct(index);
    }



}

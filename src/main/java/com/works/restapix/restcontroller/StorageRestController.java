package com.works.restapix.restcontroller;

import com.works.restapix.dto.StorageDto;
import com.works.restapix.entities.Storage;
import com.works.restapix.utils.RestEnum;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/storage")
@Api(value="Storage Rest Service")
public class StorageRestController {
    final StorageDto storageDto;


    public StorageRestController(StorageDto storageDto) {
        this.storageDto = storageDto;
    }


    @PostMapping("/add")
    public Map<RestEnum, Object> addStorage(@RequestBody Storage storage) {

        return storageDto.addStorage(storage);
    }

    @PostMapping("/update")
    public Map<RestEnum, Object> updateStorage(@RequestBody Storage storage) {

        return storageDto.updateStorage(storage);
    }


@GetMapping("/listAll")
public Map<RestEnum, Object> listStorage() {

    return storageDto.storageList();
}


    @GetMapping("/list/{index}")
    public Map<RestEnum, Object> singlelistStorage(@PathVariable String index  ) {

        return storageDto.singleStorage(index);
    }

  @GetMapping("/delete/{index}")
  public Map<RestEnum, Object> delStorage(@PathVariable String index  ) {

      return storageDto.deleteStorage(index);
  }


}

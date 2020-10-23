package com.ttdys.web.controller;

import com.ttdys.common.http.Response;
import com.ttdys.data.dto.AdvertisingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvertisingController {

    @GetMapping("/ad/launch")
    public Response<AdvertisingDTO> getAdvertising() {
        AdvertisingDTO dto = new AdvertisingDTO();
        dto.setSrc("http://localhost:8080/pic/ad");
        dto.setLink("http://localhost:8080");
        return Response.success(dto);
    }


}

package com.fastcampus.loan.controller;

import com.fastcampus.loan.dto.ApplicationDTO.Request;
import com.fastcampus.loan.dto.ApplicationDTO.Response;
import com.fastcampus.loan.dto.ResponseDTO;
import com.fastcampus.loan.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController extends AbstractController {

  private final ApplicationService applicationService;

  @PostMapping
  public ResponseDTO<Response> create(@RequestBody Request request) {
    return ok(applicationService.create(request));
  }
}
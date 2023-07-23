package com.example.leveltestmvn.controller;

import com.example.leveltestmvn.controller.dto.RequiredReminderCalculateDto;
import com.example.leveltestmvn.database.model.RequiredRemainder;
import com.example.leveltestmvn.service.RequiredRemainderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/required_reminder")
public class RequiredRemainderController {
    private final RequiredRemainderService requiredRemainderService;

    public RequiredRemainderController(RequiredRemainderService requiredRemainderService) {
        this.requiredRemainderService = requiredRemainderService;
    }

    @GetMapping(path = "",
                produces = "application/json")
    public @ResponseBody Set<RequiredRemainder> getAllRequiredRemainders() {
        return requiredRemainderService.getAll();
    }

    @PostMapping(value = "/calculate",
                 consumes = "application/json",
                 produces = "application/json")
    public ResponseEntity<RequiredRemainder> createRequiredREmainer(@RequestBody RequiredReminderCalculateDto requiredReminderCalculateDto) {
        if (requiredReminderCalculateDto.getX() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        return ResponseEntity.ok(this.requiredRemainderService.calculate(requiredReminderCalculateDto.getX(), requiredReminderCalculateDto.getY(), requiredReminderCalculateDto.getN()));
    }
}

package com.raducatalinahomework6.raducatalinahomework6.controller;

import com.raducatalinahomework6.raducatalinahomework6.exception.NoPatientException;
import com.raducatalinahomework6.raducatalinahomework6.model.Specialty;
import com.raducatalinahomework6.raducatalinahomework6.model.Visit;
import com.raducatalinahomework6.raducatalinahomework6.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/visits/all")
    public List<Visit> getAllVisits(){
        return visitService.getAllVisits();
    }

    @PostMapping(path="/visits/addvisit")
    public void addVisit(@RequestBody Visit visit) {
        visitService.addVisit(visit);
    }

    @GetMapping("/visits/getVisits")
    public List<Visit> getVisits(@RequestParam String cnp, @RequestParam Specialty specialty) throws NoPatientException {
        return visitService.getVisits(cnp,specialty);
    }
}

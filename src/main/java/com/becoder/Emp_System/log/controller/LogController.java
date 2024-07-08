package com.becoder.Emp_System.log.controller;
import com.becoder.Emp_System.log.entity.Log;
import com.becoder.Emp_System.log.model.LogModel;
import com.becoder.Emp_System.log.service.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/createlog")
    @ResponseStatus(HttpStatus.CREATED)
    public Log createLog(@Valid @RequestBody LogModel log) {
        return logService.createLog(log);
    }

    @GetMapping("/getalllogs")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("getlogbyid/{Id}")
    public Log getLogById(@PathVariable Long Id) {
        return logService.getLogById(Id);
    }


    @PutMapping("/updatelog")
    public Log updateLog(@PathVariable Long logId, @Valid @RequestBody LogModel log) {
        return logService.updateLog(logId, log);
    }

    @DeleteMapping("/deletelog")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLog(@PathVariable Long logId) {
        logService.deleteLog(logId);
    }
}

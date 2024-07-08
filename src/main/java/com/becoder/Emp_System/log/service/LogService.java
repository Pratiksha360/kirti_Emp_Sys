package com.becoder.Emp_System.log.service;

import com.becoder.Emp_System.log.entity.Log;
import com.becoder.Emp_System.log.model.LogModel;

import java.util.List;

public interface LogService {
    List<Log> getAllLogs();
    Log getLogById(Long logId);
    Log createLog(LogModel log);
    Log updateLog(Long logId, LogModel log);
    void deleteLog(Long logId);
}

package com.becoder.Emp_System.log.service;
import com.becoder.Emp_System.employee.entity.Employee;
import com.becoder.Emp_System.employee.repository.EmployeeRepository;
import com.becoder.Emp_System.log.entity.Log;
import com.becoder.Emp_System.log.model.LogModel;
import com.becoder.Emp_System.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogById(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public Log createLog(LogModel logModel) {
        Long employeeId = logModel.getEmployeeID();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

        Log log = new Log();
        log.setEmployee(employee);
        log.setLogDate(logModel.getLogDate());
        log.setLogInTime(logModel.getLogInTime());
        log.setLogOutTime(logModel.getLogOutTime());

        return logRepository.save(log);

    }

    @Override
    public Log updateLog(Long logId, LogModel updatedLog) {
        Log existingLog = logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));


        Long employeeId = updatedLog.getEmployeeID();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + employeeId));

        existingLog.setEmployee(employee);
        existingLog.setLogDate(updatedLog.getLogDate());
        existingLog.setLogInTime(updatedLog.getLogInTime());
        existingLog.setLogOutTime(updatedLog.getLogOutTime());

        return logRepository.save(existingLog);
    }

    @Override
    public void deleteLog(Long logId) {
        logRepository.deleteById(logId);
    }
}

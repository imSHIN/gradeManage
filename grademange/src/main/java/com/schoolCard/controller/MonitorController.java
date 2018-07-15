package com.schoolCard.controller;

import com.schoolCard.entity.Monitor;
import com.schoolCard.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    MonitorService monitorService;
    /*
     * 增加新监控
     * @param monitor
     * */
    @RequestMapping(value = "/insertMonitor", method = RequestMethod.POST)
    public Monitor insertMonitor(Monitor monitor) {
        if (monitor != null) {
            monitorService.insertMonitor(monitor);
        }
        return monitor;
    }

    /*
     * 删除新监控
     * @param id
     * */
    @RequestMapping(value = "/deleteMonitor", method = RequestMethod.POST)
    public int deleteMonitor(int id) {
        return monitorService.deleteMonitor(id);
    }

    /*
     * 查找一条新监控
     * @param id
     * */
    @RequestMapping(value = "/queryOne", method = RequestMethod.POST)
    public List<Monitor> queryOne(String studentid) {
        List<Monitor> t =  monitorService.queryOne(studentid);
//        Date d = t.getTime();
//        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd-HH-mm:ss");
//        System.out.println(time.format(d));
        return t;
    }

    /*
     * 查找所有新监控
     * */
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public List<Monitor> queryAll() {
        return monitorService.queryAll();
    }
}

package com.stage4linux.dogerpc.controller;
import com.stage4linux.dogerpc.service.DogeRPCConnect;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/v1/dogerpc")
@CrossOrigin(origins = { "https://127.0.0.1", "https://127.0.0.1:8443", "https://www.stage4linux.com", "https://stage4linux.com"})
public class DogeRPCClient {
    private final DogeRPCConnect rpcService;
    public DogeRPCClient(DogeRPCConnect connect) {
        this.rpcService = connect;
    }

    @GetMapping("/metrics")
    public String getMetrics(@RequestParam("rq") String method, @RequestParam("param") String param) {
        return this.rpcService.getRPCServiceResponse(method, param);
    }
}

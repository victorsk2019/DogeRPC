package com.stage4linux.dogerpc.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import com.rpclib.client.RPCClient;
import com.rpclib.util.RPCProperties;

@Service
public class DogeRPCConnect {

    @Value("${RPC_USER}")
    private String rpcuser;

    @Value("${RPC_PASSWORD}")
    private String rpcpassword;

    @Value("${rpc.ip}")
    private String rpcip;

    @Value("${rpc.port}")
    private int rpcport;

    RPCClient rpcClient;

    @PostConstruct
    public void init() {
        RPCProperties props = new RPCProperties(this.rpcuser, this.rpcpassword, this.rpcport, this.rpcip);
        this.rpcClient = new RPCClient(props);
    }

    public String getRPCServiceResponse(String method, String param) {
        return this.rpcClient.getRPCResponse(method, param);
    }
}

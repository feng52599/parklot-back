package edu.feng.parklotback.controller;

import edu.feng.parklotback.pojo.ClientUser;
import edu.feng.parklotback.service.ClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: parklot-back
 * @description:
 * @author: feng
 * @create: 2020-02-12 20:36
 */
@RestController

public class ClientUserController {
    @Autowired
    ClientUserService clientUserService;

    @CrossOrigin
    @PostMapping("api/client/merge")
    public ClientUser merge(@RequestBody ClientUser clientUser) {
        System.out.println("useriddddd" + clientUser.getId() + "name" + clientUser.getClientName());
        if ((clientUser.getId() == null) || (clientUser.getId() == 0)){
            clientUserService.save(clientUser);
        }else {
            clientUserService.updateById(clientUser);
        }
        return clientUser;
    }

    @CrossOrigin
    @PostMapping("api/client/delete")
    public void delete(@RequestBody ClientUser clientUser) throws Exception{
        clientUserService.delete(clientUser.getId());
    }

    @CrossOrigin
    @GetMapping("api/client/getall")
    public List<ClientUser> getAll() throws Exception{
        return clientUserService.findAll();
    }

}
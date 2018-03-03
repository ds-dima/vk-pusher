package vk.pusher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vk.pusher.client.VkClient;

import java.util.List;

/**
 * Created by dsshevchenko on 3/3/18.
 */
@Controller
@RequestMapping("/v1.0/vk")
public class InfoController {

    @Autowired
    private VkClient client;

    @RequestMapping("/friends")
    public List<String> getFriendsList() {
        return client.getFriends();
    }

}

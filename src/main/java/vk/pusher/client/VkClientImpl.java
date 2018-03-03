package vk.pusher.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dsshevchenko on 3/3/18.
 */
@Component
public class VkClientImpl  implements VkClient{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<String> getFriends() {
        VkUser[] users = restTemplate.getForObject("https://api.vk.com/method/friends.get?fields=nickname", VkUser[].class);
        return Stream.of(users)
                .map(u -> u.getFirst_name() + ", " + u.getLast_name())
                .collect(Collectors.toList());
    }
}

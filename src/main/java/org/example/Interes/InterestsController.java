package org.example.Interes;

import jakarta.transaction.Transactional;
import org.example.Dto.InteresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/interests")
public class InterestsController {
    @Autowired
    public final InterestsService interestsService;

    public InterestsController(InterestsService interestsService) {
        this.interestsService = interestsService;
    }

    @RequestMapping("/get")
    public List<InteresDTO> getAll(){
        return interestsService.getInterests();
    }
    @PostMapping("/update")
    @Transactional
    public void update(
            @RequestBody UpdateInterestsRequest updateInterestsRequest
    ){
        Integer userId = updateInterestsRequest.getUserId();
        Integer[] interestIds = updateInterestsRequest.getInterests();
        interestsService.updateInterests(userId, interestIds);
    }
}

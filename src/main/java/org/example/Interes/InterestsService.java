package org.example.Interes;

import org.example.Dto.InteresDTO;
import org.example.user.User;
import org.example.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestsService {
    @Autowired
    private final InterestsRepository interestsRepository;
    @Autowired
    private final UserInterestsRepository userInterestsRepository;
    @Autowired
    private final UserRepository userRepository;


    public InterestsService(InterestsRepository interestsRepository, UserInterestsRepository userInterestsRepository, UserRepository userRepository) {
        this.interestsRepository = interestsRepository;
        this.userInterestsRepository = userInterestsRepository;
        this.userRepository = userRepository;
    }
    public List<InteresDTO> getInterests(){
        return interestsRepository.findAll().stream()
                .map(InteresDTO::mapFromInterests)
                .collect(Collectors.toList());
    }
    public void updateInterests(Integer userId, Integer[] interests){
        userInterestsRepository.deleteAllByUserId(userId);
        User user = userRepository.findById(userId).orElse(null);
        for (Integer interestId : interests) {
            Interests interest = interestsRepository.findById(interestId).orElse(null);
            if (user != null && interest != null) {
                UsersInterests userInterest = new UsersInterests();
                userInterest.setUser(user);
                userInterest.setInterest(interest);
                userInterestsRepository.save(userInterest);
            }
        }
    }
}

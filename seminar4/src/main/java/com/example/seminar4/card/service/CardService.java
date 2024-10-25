package com.example.seminar4.card.service;

import com.example.seminar4.card.dto.CardRequest;
import com.example.seminar4.card.entity.Card;
import com.example.seminar4.card.repo.CardRepo;
import com.example.seminar4.user.dto.UserResponse;
import com.example.seminar4.user.entity.User;
import com.example.seminar4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepo cardRepo;
    private final UserRepo userRepo;

    public void CreateCard(CardRequest.CardCreateRequest request){
        Optional<User> users=userRepo.findById(request.getUserId());
        User user=users.get();

        Card card=Card.builder().id(null).name(request.getName()).user(user).build();
        card.assignUser(user);
        cardRepo.save(card);
        userRepo.save(user);

    }
}

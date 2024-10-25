package com.example.seminar4.book.service;

import com.example.seminar4.book.dto.BookRequest;
import com.example.seminar4.book.dto.BookResponse;
import com.example.seminar4.book.entity.Book;
import com.example.seminar4.book.repo.BookRepo;
import com.example.seminar4.user.entity.User;
import com.example.seminar4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public void createBook(Long userId, BookRequest.BookCreateRequest request) {
        Optional<User> users = userRepo.findById(userId);
        User user=users.get();
        Book book=Book.from(request.getTitle(), user);
        bookRepo.save(book);
    }
    public BookResponse.BookReadResponse readBook(Long bookId){
        Optional<Book>books=bookRepo.findById(bookId);
        Book book=books.get();
        return new BookResponse.BookReadResponse(bookId,book.getTitle());
    }


}

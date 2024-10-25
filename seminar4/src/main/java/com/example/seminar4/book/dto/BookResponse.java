package com.example.seminar4.book.dto;

import com.example.seminar4.book.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookReadResponse {
        private Long bookId;
        private String title;

        public static List<BookReadResponse>bookToDto(List<Book> books) {
            List<BookReadResponse> bookReadResponses = new ArrayList<>();
            for(Book book : books) {
                BookReadResponse bookReadResponse = new BookReadResponse(book.getId(),book.getTitle());
                bookReadResponses.add(bookReadResponse);
            }
            return bookReadResponses;
        }
    }
}

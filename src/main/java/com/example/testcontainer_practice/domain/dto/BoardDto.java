package com.example.testcontainer_practice.domain.dto;

import com.example.testcontainer_practice.entity.Board;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

public class BoardDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String title;
        private String contents;
        private String author;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String contents;
        private String title;
        private String author;
        private String createdBy;
        private String updatedBy;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime createdTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime updatedTime;

        @Builder
        public Response(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.contents = board.getContents();
            this.author = board.getAuthor();
            this.createdBy = board.getCreatedBy();
            this.updatedBy = board.getUpdatedBy();
            this.createdTime = board.getCreatedTime();
            this.updatedTime = board.getUpdatedTime();
        }
    }
}

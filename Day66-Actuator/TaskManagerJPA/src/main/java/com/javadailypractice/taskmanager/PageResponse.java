package com.javadailypractice.taskmanager;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponse<T>(List<T> content, int currentPage, int totalItems, int totalPages) {

    public static <T> PageResponse<T> from(Page<T> page) {
        return new PageResponse<>(
                page.getContent(),
                page.getNumber(),
                (int) page.getTotalElements(),
                page.getTotalPages()
        );
    }
}

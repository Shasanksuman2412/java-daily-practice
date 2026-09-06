package com.javadailypractice.taskmanager;

import org.springframework.data.domain.Page;

import java.util.List;

// A generic record (Day 35) - works for ANY content type, so it's reused
// for both paginated Tasks and paginated Projects. Much cleaner than
// Spring's raw Page JSON, which includes verbose internal fields like
// "pageable", "sort", "first", "empty" that clients don't actually need.
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

package kea.project.searchservice.api.controller;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.service.SearchService;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping(value = "/blog")
    public ResponseEntity<Page<BlogSearchResponse>> blogSearch(@RequestParam String value, @RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseEntity.ok(searchService.blogSearch(BlogSearchDto.of(value, limit, page)));
    }
}

package kea.project.searchservice.api.controller;

import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.controller.dto.PostSearchResponse;
import kea.project.searchservice.api.service.SearchService;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import kea.project.searchservice.api.service.dto.MemberSearchDto;
import kea.project.searchservice.api.service.dto.OrderType;
import kea.project.searchservice.api.service.dto.PostSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping(value = "/blog")
    public ResponseEntity<Page<BlogSearchResponse>> blogSearch(@RequestParam String value, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(searchService.blogSearch(BlogSearchDto.of(value, size, page)));
    }

    @GetMapping(value = "/member")
    public ResponseEntity<Page<MemberSearchResponse>> memberSearch(@RequestParam String value, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(searchService.memberSearch(MemberSearchDto.of(value, size, page)));
    }

    @GetMapping(value = "/post")
    public ResponseEntity<Page<PostSearchResponse>> postSearch(@RequestParam String value, @RequestParam Integer page,
                                                               @RequestParam Integer size, @RequestParam OrderType order,
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate startDate,
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(searchService.postSearch(PostSearchDto.of(value, size, page, order, startDate, endDate)));
    }
}

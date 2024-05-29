package kea.project.searchservice.api.controller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class BlogSearchResponse {
    private Long blogId;
    private String blogName;
    private String blogAbout;
    private String blogOwnerName;
    private String blogOwnerImageUrl;

    @Builder
    @QueryProjection
    public BlogSearchResponse(Long blogId, String blogName, String blogAbout, String blogOwnerName, String blogOwnerImageUrl) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogAbout = blogAbout;
        this.blogOwnerName = blogOwnerName;
        this.blogOwnerImageUrl = blogOwnerImageUrl;
    }


    public static BlogSearchResponse of(Long blogId, String blogName, String blogAbout, String blogOwnerName, String blogOwnerImageUrl) {
        return BlogSearchResponse.builder()
                .blogId(blogId)
                .blogName(blogName)
                .blogAbout(blogAbout)
                .blogOwnerName(blogOwnerName)
                .blogOwnerImageUrl(blogOwnerImageUrl)
                .build();
    }
}

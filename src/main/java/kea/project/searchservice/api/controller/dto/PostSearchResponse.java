package kea.project.searchservice.api.controller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@ToString
public class PostSearchResponse {
    private Long postId;
    private String postTitle;
    private String postPreview;
    private String postedDAte;
    private String postThumbnailUrl;
    private String repHashTag;
    private String postOwnerName;
    private String postOwnerImageUrl;

    @Builder
    public PostSearchResponse(Long postId, String postTitle, String postPreview, String postedDAte, String postThumbnailUrl, String repHashTag, String postOwnerName, String postOwnerImageUrl) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postPreview = postPreview;
        this.postedDAte = postedDAte;
        this.postThumbnailUrl = postThumbnailUrl;
        this.repHashTag = repHashTag;
        this.postOwnerName = postOwnerName;
        this.postOwnerImageUrl = postOwnerImageUrl;
    }
    @QueryProjection
    public PostSearchResponse(Long postId, String postTitle, String postPreview, LocalDateTime postedDAte, String postThumbnailUrl, String repHashTag, String postOwnerName, String postOwnerImageUrl) {

        this.postId = postId;
        this.postTitle = postTitle;
        this.postPreview = postPreview;
        this.postedDAte = postedDAte.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.postThumbnailUrl = postThumbnailUrl;
        this.repHashTag = repHashTag;
        this.postOwnerName = postOwnerName;
        this.postOwnerImageUrl = postOwnerImageUrl;
    }

    public static PostSearchResponse of(Long postId, String postTitle, String postPreview, String postedDAte, String postThumbnailUrl, String repHashTag, String postOwnerName, String postOwnerImageUrl) {
        return PostSearchResponse.builder()
                .postId(postId)
                .postTitle(postTitle)
                .postPreview(postPreview)
                .postedDAte(postedDAte)
                .postThumbnailUrl(postThumbnailUrl)
                .repHashTag(repHashTag)
                .postOwnerName(postOwnerName)
                .postOwnerImageUrl(postOwnerImageUrl)
                .build();
    }
}

package kea.project.searchservice.api.controller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSearchResponse {
    private Long memberId;
    private Long blogId;
    private String memberNickname;
    private String memberAbout;
    private String memberImageUrl;

    @Builder
    @QueryProjection
    public MemberSearchResponse(Long memberId, Long blogId, String memberNickname, String memberAbout, String memberImageUrl) {
        this.memberId = memberId;
        this.blogId = blogId;
        this.memberNickname = memberNickname;
        this.memberAbout = memberAbout;
        this.memberImageUrl = memberImageUrl;
    }
}

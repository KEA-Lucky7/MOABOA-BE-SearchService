package kea.project.searchservice.api.service;

import kea.project.searchservice.IntegrationTestSupport;
import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.controller.dto.PostSearchResponse;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import kea.project.searchservice.api.service.dto.MemberSearchDto;
import kea.project.searchservice.api.service.dto.OrderType;
import kea.project.searchservice.api.service.dto.PostSearchDto;
import kea.project.searchservice.domain.blog.entity.BlogEntity;
import kea.project.searchservice.domain.blog.vo.BlogEntityState;
import kea.project.searchservice.domain.member.entity.MemberEntity;
import kea.project.searchservice.domain.member.vo.MemberEntityState;
import kea.project.searchservice.domain.member.vo.MemberEntityRole;
import kea.project.searchservice.domain.post.entity.PostEntity;
import kea.project.searchservice.domain.post.entity.PostLikeEntity;
import kea.project.searchservice.domain.post.vo.PostEntityState;
import kea.project.searchservice.domain.post.vo.PostEntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class SearchServiceTest extends IntegrationTestSupport {

    @DisplayName(value = "제목을 기준으로 블로그를 검색할때 앞글자 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithTitleFirstCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "about", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("별", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(1);
    }

    @DisplayName(value = "제목을 기준으로 블로그를 검색할때 뒷글자 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithTitleLastCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "about", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("3", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(1);
    }

    @DisplayName(value = "제목을 기준으로 블로그를 검색할때 가운대 글자 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithTitleMiddleCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "about", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("블", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(3);
    }

    @DisplayName(value = "블로그 소개를 기준으로 블로그를 검색할때 첫번째 글자 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithAboutFirstCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("이", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(1);
    }

    @DisplayName(value = "블로그 소개를 기준으로 블로그를 검색할때 마지막 글자 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithAboutLastCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("미래", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(1);
    }


    @DisplayName(value = "블로그 소개를 기준으로 블로그를 검색할때 마지막 중간 기준으로 검색해도 된다.")
    @Test
    public void blogSearchWithAboutMiddleCharacter() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3"));
        blogJPARepository.save(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
        BlogSearchDto blogSearchDto = BlogSearchDto.of("미래", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(1);
    }

    @DisplayName(value = "블로그 검색할 때 정렬 기준은 업데이트날짜이다.")
    @Test
    public void blogSearchStandardIsUpdateAt() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1"));
        BlogEntity blogEntity1 = blogJPARepository.saveAndFlush(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        BlogEntity blogEntity2 = blogJPARepository.saveAndFlush(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.saveAndFlush(createMemberEntity("이름3"));
        BlogEntity blogEntity3 = blogJPARepository.saveAndFlush(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
        blogEntity2.updateName("블로그4");
        blogJPARepository.saveAndFlush(blogEntity2);
        BlogSearchDto blogSearchDto = BlogSearchDto.of("블로그", 10, 0);

        //when
        Page<BlogSearchResponse> blogSearchResponses = searchService.blogSearch(blogSearchDto);

        //then
        assertThat(blogSearchResponses.getTotalElements()).isEqualTo(3);
        assertThat(blogSearchResponses.getContent())
                .extracting("BlogName")
                .containsExactly(blogEntity2.getName(), blogEntity3.getName(), blogEntity1.getName());
    }

    @DisplayName(value = "유저를 검색할 때 닉네임 앞 글자를 기준으로 검색해도 된다. ")
    @Test
    public void memberSearchWithNicknameFirstCharacter() {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok"));
        blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberSearchDto memberSearchDto = MemberSearchDto.of("dong", 10, 0);

        //when
        Page<MemberSearchResponse> memberSearchResponses = searchService.memberSearch(memberSearchDto);

        //then
        assertThat(memberSearchResponses.getTotalElements()).isEqualTo(1);
        assertThat(memberSearchResponses.getContent())
                .extracting("memberNickname")
                .isEqualTo(Collections.singletonList("dongseok"));

    }

    @DisplayName(value = "유저를 검색할 때 닉네임 뒷 글자를 기준으로 검색해도 된다. ")
    @Test
    public void memberSearchWithNicknameEndCharacter() {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok"));
        blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberSearchDto memberSearchDto = MemberSearchDto.of("seok", 10, 0);

        //when
        Page<MemberSearchResponse> memberSearchResponses = searchService.memberSearch(memberSearchDto);

        //then
        assertThat(memberSearchResponses.getTotalElements()).isEqualTo(1);
        assertThat(memberSearchResponses.getContent())
                .extracting("memberNickname")
                .isEqualTo(Collections.singletonList("dongseok"));

    }

    @DisplayName(value = "유저를 검색할 때 닉네임 중간 글자를 기준으로 검색해도 된다. ")
    @Test
    public void memberSearchWithNicknameMiddleCharacter() {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok"));
        blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberSearchDto memberSearchDto = MemberSearchDto.of("gs", 10, 0);

        //when
        Page<MemberSearchResponse> memberSearchResponses = searchService.memberSearch(memberSearchDto);

        //then
        assertThat(memberSearchResponses.getTotalElements()).isEqualTo(1);
        assertThat(memberSearchResponses.getContent())
                .extracting("memberNickname")
                .isEqualTo(Collections.singletonList("dongseok"));

    }

    @DisplayName(value = "유저 검색할 때 정렬 기준은 업데이트날짜이다.")
    @Test
    public void memberSearchStandardIsUpdateAt() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.saveAndFlush(createMemberEntity("Name1"));
        blogJPARepository.saveAndFlush(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.saveAndFlush(createMemberEntity("Name2"));
        blogJPARepository.saveAndFlush(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.saveAndFlush(createMemberEntity("Name3"));
        blogJPARepository.saveAndFlush(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
        memberEntity2.updateNickname("updateName");
        memberJPARepository.saveAndFlush(memberEntity2);
        MemberSearchDto memberSearchDto = MemberSearchDto.of("Name", 10, 0);

        //when
        Page<MemberSearchResponse> memberSearchResponses = searchService.memberSearch(memberSearchDto);

        //then
        assertThat(memberSearchResponses.getTotalElements()).isEqualTo(3);
        assertThat(memberSearchResponses.getContent())
                .extracting("memberNickname")
                .containsExactly("updateName", memberEntity3.getNickname(), memberEntity1.getNickname());
    }

    @DisplayName(value = "제목에 포함된 글자를 기준으로 글을 검색한다.")
    @Test
    public void postSearchContainTitle() {
        //given
        MemberEntity memberEntity = memberJPARepository.saveAndFlush(createMemberEntity("Name1"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        String title = "하늘의 제목";
        String preview = "새의 꿈";
        String content = "땅의 본문";
        PostEntity postEntity1 = postJPARepository.save(createPostEntity(memberEntity, blogEntity, title, content, preview));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "Wrong", "another", "preview"));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "Wrong2", "another2", "preview2"));
        PostSearchDto dto = PostSearchDto.of("늘의", 10, 0, OrderType.latestASC, postEntity1.getCreatedAt().toLocalDate().minusMonths(1), postEntity1.getUpdatedAt().toLocalDate().plusMonths(1));

        //when
        Page<PostSearchResponse> result = searchService.postSearch(dto);
        System.out.println(result.getContent());
        //then
        assertThat(result.getTotalElements()).isEqualTo(1);
        assertThat(result.getContent().get(0).getPostTitle()).isEqualTo(postEntity1.getTitle());
    }

    @DisplayName(value = "본문에 포함된 글자를 기준으로 글을 검색한다.")
    @Test
    public void postSearchContainContent() {
        //given
        MemberEntity memberEntity = memberJPARepository.saveAndFlush(createMemberEntity("Name1"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        String title = "하늘의 제목";
        String preview = "새의 꿈";
        String content = "땅의 본문";
        PostEntity postEntity1 = postJPARepository.save(createPostEntity(memberEntity, blogEntity, title, content, preview));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "Wrong", "another", "preview"));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "Wrong2", "another2", "preview2"));
        PostSearchDto dto = PostSearchDto.of("의 본", 10, 0, OrderType.latestASC, postEntity1.getCreatedAt().toLocalDate().minusMonths(1), postEntity1.getUpdatedAt().toLocalDate().plusMonths(1));

        //when
        Page<PostSearchResponse> result = searchService.postSearch(dto);
        System.out.println(result.getContent());
        //then
        assertThat(result.getTotalElements()).isEqualTo(1);
        assertThat(result.getContent().get(0).getPostPreview()).isEqualTo(postEntity1.getPreview());
    }

    @DisplayName(value = "글을 검색할때 최신순으로 정렬한다.")
    @Test
    public void postSearchSortByLatestASC() {
        //given
        MemberEntity memberEntity = memberJPARepository.saveAndFlush(createMemberEntity("Name1"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        PostEntity postEntity1 = postJPARepository.save(createPostEntity(memberEntity, blogEntity, "title1", "content1", "preview1"));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "title2", "content2", "preview2"));
        postJPARepository.save(createPostEntity(memberEntity, blogEntity, "title3", "content3", "preview3"));
        PostSearchDto dto = PostSearchDto.of("title", 10, 0, OrderType.latestASC, postEntity1.getCreatedAt().toLocalDate().minusMonths(1), postEntity1.getUpdatedAt().toLocalDate().plusMonths(1));

        //when
        Page<PostSearchResponse> result = searchService.postSearch(dto);

        //then
        assertThat(result.getTotalElements()).isEqualTo(3);
        assertThat(result.getContent())
                .extracting("postTitle")
                .containsExactly("title3", "title2", "title1");
    }

    @DisplayName(value = "글을 검색할때 인기순으로 정렬한다.")
    @Test
    public void postSearchSortByLikeDESC() {
        //given
        MemberEntity memberEntity1 = memberJPARepository.saveAndFlush(createMemberEntity("Name1"));
        MemberEntity memberEntity2 = memberJPARepository.saveAndFlush(createMemberEntity("Name2"));
        MemberEntity memberEntity3 = memberJPARepository.saveAndFlush(createMemberEntity("Name3"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity1));
        PostEntity postEntity1 = postJPARepository.save(createPostEntity(memberEntity1, blogEntity, "title1", "content1", "preview1"));
        PostEntity postEntity2 = postJPARepository.save(createPostEntity(memberEntity1, blogEntity, "title2", "content2", "preview2"));
        PostEntity postEntity3 = postJPARepository.save(createPostEntity(memberEntity1, blogEntity, "title3", "content3", "preview3"));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity1, postEntity1));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity1, postEntity2));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity1, postEntity3));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity2, postEntity2));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity2, postEntity3));
        postLikeJPARepository.save(createPostLikeEntity(memberEntity3, postEntity2));
        PostSearchDto dto = PostSearchDto.of("title", 10, 0, OrderType.likeDESC, postEntity1.getCreatedAt().toLocalDate().minusMonths(1), postEntity1.getUpdatedAt().toLocalDate().plusMonths(1));

        //when
        Page<PostSearchResponse> result = searchService.postSearch(dto);

        //then
        assertThat(result.getTotalElements()).isEqualTo(3);
        assertThat(result.getContent())
                .extracting("postTitle")
                .containsExactly("title2", "title3", "title1");
    }

    private PostEntity createPostEntity(MemberEntity memberEntity, BlogEntity blogEntity, String title, String content, String preview) {
        return PostEntity.of(memberEntity, blogEntity, PostEntityType.FREE, title, content, preview, "thumbnail", "hashtag", PostEntityState.ACTIVE);
    }

    private MemberEntity createMemberEntity(String nickname) {
        LocalDate Birthday = LocalDate.of(1999, 8, 20);
        return MemberEntity.of(Birthday, "about", nickname, "image.png", "123", "GOOGLE", MemberEntityState.ACTIVE, MemberEntityRole.MEMBER);
    }

    private BlogEntity createBlogEntity(String blogName, String about, MemberEntity memberEntity) {
        return BlogEntity.of(memberEntity, about, blogName, "imageUrl", BlogEntityState.ACTIVE);
    }

    private PostLikeEntity createPostLikeEntity(MemberEntity memberEntity, PostEntity postEntity) {
        return PostLikeEntity.of(memberEntity, postEntity);
    }
}
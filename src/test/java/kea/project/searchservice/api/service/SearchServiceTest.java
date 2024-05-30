package kea.project.searchservice.api.service;

import kea.project.searchservice.IntegrationTestSupport;
import kea.project.searchservice.api.controller.dto.BlogSearchResponse;
import kea.project.searchservice.api.controller.dto.MemberSearchResponse;
import kea.project.searchservice.api.service.dto.BlogSearchDto;
import kea.project.searchservice.api.service.dto.MemberSearchDto;
import kea.project.searchservice.domain.blog.entity.BlogEntity;
import kea.project.searchservice.domain.blog.vo.BlogEntityState;
import kea.project.searchservice.domain.member.entity.MemberEntity;
import kea.project.searchservice.domain.member.vo.MemberEntityState;
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "about", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        blogJPARepository.save(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.save(createMemberEntity("이름3", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.save(createMemberEntity("이름1", "dongseok_profile.png"));
        BlogEntity blogEntity1 = blogJPARepository.saveAndFlush(createBlogEntity("구름_블로그1", "이 블로그는 자유", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
        BlogEntity blogEntity2 = blogJPARepository.saveAndFlush(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.saveAndFlush(createMemberEntity("이름3", "dongseok_profile.png"));
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
    public void memberSearchWithNicknameFirstCharacter() throws Exception {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok", "dongseok_profile.png"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
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
    public void memberSearchWithNicknameEndCharacter() throws Exception {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok", "dongseok_profile.png"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
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
    public void memberSearchWithNicknameMiddleCharacter() throws Exception {
        //given
        MemberEntity memberEntity = memberJPARepository.save(createMemberEntity("dongseok", "dongseok_profile.png"));
        BlogEntity blogEntity = blogJPARepository.save(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity));
        MemberEntity memberEntity2 = memberJPARepository.save(createMemberEntity("이름2", "dongseok_profile.png"));
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
        MemberEntity memberEntity1 = memberJPARepository.saveAndFlush(createMemberEntity("Name1", "dongseok_profile.png"));
        BlogEntity blogEntity2 = blogJPARepository.saveAndFlush(createBlogEntity("dongseok_blog", "dongseok_blog_about", memberEntity1));
        MemberEntity memberEntity2 = memberJPARepository.saveAndFlush(createMemberEntity("Name2", "dongseok_profile.png"));
        blogJPARepository.saveAndFlush(createBlogEntity("바람_블로그2", "요 블로그는 미래", memberEntity2));
        MemberEntity memberEntity3 = memberJPARepository.saveAndFlush(createMemberEntity("Name3", "dongseok_profile.png"));
        BlogEntity blogEntity3 = blogJPARepository.saveAndFlush(createBlogEntity("별_블로그3", "내 블로그는 꿈", memberEntity3));
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

    private MemberEntity createMemberEntity(String nickname, String imgUrl) {
        LocalDate Birthday = LocalDate.of(1999, 8, 20);
        return MemberEntity.of(Birthday, "about", nickname, imgUrl, "123", "GOOGLE", MemberEntityState.ACTIVE);
    }

    private BlogEntity createBlogEntity(String blogName, String about, MemberEntity memberEntity) {
        return BlogEntity.of(memberEntity, about, blogName, "imageUrl", BlogEntityState.ACTIVE);
    }
}
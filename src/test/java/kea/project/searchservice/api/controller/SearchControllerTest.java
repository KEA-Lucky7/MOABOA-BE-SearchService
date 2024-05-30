package kea.project.searchservice.api.controller;

import kea.project.searchservice.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SearchControllerTest extends ControllerTestSupport {
    @DisplayName(value="블로그를 검색한다.")
    @Test
    public void blogSearch() throws Exception {
        //given
        String value = "value";
        Integer page = 1;
        Integer size = 10;
        mockMvc.perform(
                get("/search/blog")
                        .param("value", value)
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size))
        ).andExpect(status().isOk());
    }

    @DisplayName(value="블로그를 검색한다.")
    @Test
    public void memberSearch() throws Exception {
        //given
        String value = "value";
        Integer page = 1;
        Integer size = 10;
        mockMvc.perform(
                get("/search/member")
                        .param("value", value)
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size))
        ).andExpect(status().isOk());
    }
}
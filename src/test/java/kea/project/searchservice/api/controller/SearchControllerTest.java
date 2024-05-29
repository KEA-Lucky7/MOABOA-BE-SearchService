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
        mockMvc.perform(
                get("/search/blog")
        ).andExpect(status().isOk());
    }
}
package kea.project.searchservice.api.controller;

import kea.project.searchservice.ControllerTestSupport;
import kea.project.searchservice.api.service.dto.OrderType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @DisplayName(value="게시글를 검색한다.")
    @Test
    public void postSearch() throws Exception {
        //given
        String value = "value";
        Integer page = 1;
        Integer size = 10;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2020, 12, 31);
        OrderType orderType = OrderType.likeDESC;
        mockMvc.perform(
                get("/search/post")
                        .param("value", value)
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size))
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString())
                        .param("order", orderType.toString())
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
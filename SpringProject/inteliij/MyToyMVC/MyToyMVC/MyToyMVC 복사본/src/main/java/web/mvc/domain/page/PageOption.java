package web.mvc.domain.page;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageOption {

    private String searchType;
    private String keyword;

    // 게시판의 검색 옵션 사용자가 게시물을 검색할 때 (제목,내용,작성자)
    // -> searchType 그리고 검색어 -> keyword
}

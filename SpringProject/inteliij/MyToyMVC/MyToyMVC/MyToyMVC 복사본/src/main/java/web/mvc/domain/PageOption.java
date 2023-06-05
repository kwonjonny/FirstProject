package web.mvc.domain;

import lombok.*;
import web.mvc.domain.page.BoardSearchOption;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageOption {

    private BoardSearchOption boardSearchOption;
    private int startNumber;
    private int count;

    // 게시물의 리스트를 가져오는데 필요한 여러가지 옵션을 담는 클래스
    // 검색옵션 pageOption 몇 번째 게시물 부터 가져올지를 결정하는
    // 시작번호 startNumber 그리고 한 페이지에 몇개의 게시물을 가져올지 count

}

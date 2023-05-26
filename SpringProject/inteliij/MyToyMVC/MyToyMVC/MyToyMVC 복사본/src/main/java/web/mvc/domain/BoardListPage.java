package web.mvc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {

    // 게시물 리스트와 페이지네이션을 관리 하기 위한 클래스
    // 한 페이지에 몇개의 게시물을 보여줄지 countPerPage
    // 현재 페이지가 몇 번인지 pageNumber
    // 현재 페이지에 표시할 게시물 목록 list
    // 전체 게시물의 수 totalCount


    // 페이지 당 출력할 게시물의 개수
    private int countPerPage;
    // 현재 페이지 번호
    private int pageNumber;
    // 게시물 리스트 List<TblBoard>
    private List<TblBoard> list;
    // 전체 게시물 개수
    private int totalCount;

    // 페이징 시작 번호
    private int startNumber;
    // 페이징 끝 번호
    private int endNumber;
    // 이전 버튼 출력 유무
    private boolean prev;
    // 다음 버튼 출력 유무
    private boolean next;

    public BoardListPage(int countPerPage, int pageNumber, List<TblBoard> list, int totalCount) {
        this.countPerPage = countPerPage;
        this.pageNumber = pageNumber;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {
        // 끝 번호
        // Math.ceil : 소수점 이하의 값을 무조건 올림
        this.endNumber = (int)(Math.ceil(this.pageNumber*1.0/10))*10;

        // 시작 번호
        this.startNumber = this.endNumber - 9;

        // 실제 끝 번호 : 전체 페이지 끝번호
        int realEndNumber = (int)(Math.ceil(this.totalCount * 1.0 / countPerPage));

        // endNumber
        this.endNumber = realEndNumber < this.endNumber ? realEndNumber : this.endNumber;

        // 이전 유무
        this.prev = this.startNumber > 1;

        // 다음 유무 : 현재 구간의 마지막 번호 < realEndNumber
        this.next = this.endNumber < realEndNumber;
    }
}

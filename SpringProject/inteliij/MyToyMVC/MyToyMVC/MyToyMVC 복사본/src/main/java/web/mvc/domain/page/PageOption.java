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

}

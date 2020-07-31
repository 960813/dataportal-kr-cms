package kr.dataportal.cms.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
// TODO: 2020-07-31 오후 9:11 게시판 Domain 생성 -Jinssssun
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long owner;

    String title;

    String content;
}

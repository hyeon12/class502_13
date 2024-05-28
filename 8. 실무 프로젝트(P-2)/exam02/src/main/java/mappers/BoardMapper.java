package mappers;

import member.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> select();

    int register(Board board);

    int modify(Board board);

    int delete(String poster);
}

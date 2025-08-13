package com.rubypaper.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepo;
    

	@Override
	public List<Board> getBoardList() {
		return boardRepo.findAll();
	}

	@Override
	public Board getBoard(Board board) {
	    Board findBoard = boardRepo.findById(board.getSeq()).get();
	    findBoard.setCnt(findBoard.getCnt() + 1);  
	    boardRepo.save(findBoard);                 
	    return findBoard;                          
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
		
	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());

	}
}

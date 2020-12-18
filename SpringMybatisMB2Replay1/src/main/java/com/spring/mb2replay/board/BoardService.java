package com.spring.mb2replay.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.spring.mb2replay.member.*;

public interface BoardService {
	public int getListCount();
	public List<BoardVO> getBoardList(HashMap<String, Integer> hashmap);
	public BoardVO getDetail(int num);
	public int boardInsert(BoardVO board); 
	public int boardReply(BoardVO board); 
	public BoardVO boardModifyForm(BoardVO modifyboard);
	public int boardDelete(HashMap<String, String> hashmap);
	public int boardModify(BoardVO modifyboard);
	
}
	
	


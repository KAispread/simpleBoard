package com.board.mvc.view.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.mvc.view.domain.BoardVO;

@Repository
public class BoardDaoMyBatis implements BoardDao {
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("delete", boardVO);
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("update", boardVO);
	}

	@Override
	public void insert(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insert", boardVO);
	}

	@Override
	public BoardVO select(int seq) {
		// TODO Auto-generated method stub
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}

	@Override
	public int updateReadCount(int seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("update", seq);
	}
}

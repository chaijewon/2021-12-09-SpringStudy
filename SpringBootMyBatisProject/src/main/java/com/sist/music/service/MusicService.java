package com.sist.music.service;

import java.util.List;
import java.util.Map;

import com.sist.music.vo.MusicVO;

public interface MusicService {
	public List<MusicVO> musicListData(Map map);
	public int musicTotalPage(int cno);
}

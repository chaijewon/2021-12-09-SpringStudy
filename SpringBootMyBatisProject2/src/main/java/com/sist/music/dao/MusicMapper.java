package com.sist.music.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.music.vo.*;
@Repository
@Mapper
public interface MusicMapper {
   public List<MusicVO> musicListData(Map map);
   public int musicTotalPage(int cno);
}

package com.sist.temp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicManager {
  public static void main(String[] args) {
	MusicManager m=new MusicManager();
	m.genieMusic();
  }
  /*
   *  <tr class="list" songid="90705547">
       <td class="check"><input type="checkbox" class="select-check" title="Dynamite"></td>
       <td class="number">51
        <span class="rank">
         <span class="rank">
           <span class="rank-up">7
            <span class="hide">상승</span>
           </span>
         </span>
        </span>
      </td>
      <td><a href="#" class="cover" onclick="fnViewAlbumLayer('81545399');return false;"><span class="mask"></span><img src="//image.genie.co.kr/Y/IMAGE/IMG_ALBUM/081/545/399/81545399_1600401677905_1_140x140.JPG/dims/resize/Q_80,0" onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" alt="Dynamite (DayTime Ver.)"></a></td>
      <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo('90705547');return false;">곡 제목 정보 페이지</a></td>
      <td class="info">
           <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('90705547','1');return false;">
                 Dynamite</a>
           <a href="#" class="artist ellipsis" onclick="fnViewArtist('80221635');return false;">방탄소년단</a>
                                        
           <div class="toggle-button-box">
           <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('90705547');">외</button>
           <ul class="list" id="RelationArtist_90705547"></ul>
                                        </div>
                                        
           <i class="bar">|</i>
           <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('81545399');return false;">Dynamite (DayTime Ver.)</a>
                                </td>
                                
   */
  public void genieMusic()
  {
	  MusicDAO dao=new MusicDAO();
	  try
	  {
		  int k=1;
		  for(int i=1;i<=2;i++)
		  {
			  //HTML을 읽어 와서 메모리 저장 
			  Document doc=Jsoup.connect("https://www.genie.co.kr/chart/musicHistory?year=2021&category=0&pg="+i).get();
		      Elements title=doc.select("td.info a.title");
		      Elements singer=doc.select("td.info a.artist");
		      Elements album=doc.select("td.info a.albumtitle");
		      Elements poster=doc.select("a.cover img");
		      Elements etc=doc.select("td.number span.rank");// state,idcrement
		      
		      for(int j=0;j<title.size();j++)
		      {
		    	  System.out.println("곡명:"+title.get(j).text());
		    	  System.out.println("가수명:"+singer.get(j).text());
		    	  System.out.println("앨범:"+album.get(j).text());
		    	  System.out.println("포스터:"+poster.get(j).attr("src"));
		    	  String tmp=etc.get(j).text();
		    	  String state=tmp.replaceAll("[^가-힣]", "");
		    	  // 10하강,상승,유지 
		    	  int idcrment=0;
		    	  if(state.equals("유지"))
		    	  {
		    		  idcrment=0;
		    	  }
		    	  else 
		    	  {
		    		  if(state.equals("상승") || state.equals("하강"))
		    		  {
		    		    idcrment=Integer.parseInt(tmp.replaceAll("[^0-9]", "").trim());
		    		  }
		    		  else if(!(state.equals("유지")||state.equals("상승") || state.equals("하강")))
		    		  {
		    			  state="new";
		    			  idcrment=0;
		    		  }
		    	  }
		    	  System.out.println("상태:"+state);
		    	  System.out.println("등폭:"+idcrment);
		    	  //System.out.println("key:"+getMkeyData(title.get(j).text()));
		    	  System.out.println("=================================");
		          MusicVO vo=new MusicVO();
		          vo.setCno(7);
		          vo.setTitle(title.get(j).text());
		          vo.setSinger(singer.get(j).text());
		          vo.setPoster(poster.get(j).attr("src"));
		          vo.setState(state);
		          vo.setIdcrement(idcrment);
		          vo.setAlbum(album.get(j).text());
		          vo.setMkey(getMkeyData(title.get(j).text()));
		          dao.musicInsert(vo);
		          System.out.println("k="+k);
		          k++;   
		      }
		  }
		  System.out.println("저장완료!!");
	  }catch(Exception ex){}
  }
  public String getMkeyData(String title)
  {
	  //https://www.youtube.com/results?search_query=%EB%B4%84%EC%97%AC%EB%A6%84%EA%B0%80%EC%9D%84%EA%B2%A8%EC%9A%B8+(still+life)
	  String key="";
	  try
	  {
		  Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
	      String data=doc.toString();
	      // ?는 정규식에서 이미 사용하는 기호 => ?자체를 출력하기 위해서는 \\?
	      // ^ , +  , * , . => \\. \\+
	      Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
	      Matcher m=p.matcher(data);
	      /*
	       *    (aaa)(bbb)(ccc)
	       */
	      while(m.find())
	      {
	    	  String s=m.group();//실제값을 읽어 온다 
	    	  // /watch?v=mOLxEqVaRnE","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}}
	    	  key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
	    	  break;
	      }
	  }catch(Exception ex){}
	  return key;
  }
}

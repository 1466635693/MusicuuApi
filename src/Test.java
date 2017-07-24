import MusicService.NetUtil;
import MusicService.Util;

/**
 * Created by qtfreet on 2017/3/2.
 */
public class Test {
    private static final String HOST = "http://music.163.com/weapi/cloudsearch/get/web?csrf_token=";

    public static void main(String[] args) {
        System.out.println(Util.getXiaMp3Url("4h%2F.cc24642E22F4954_pFhy255dd26425155EElt3FoadoF%4%1%1418287h3a_%cEc414b66%2EE--ltA%mlnm4242%53%79696.%uk3438b8f9e-518%%np%26i.%7F7F5E6273_24m3teD%ed7bd381E%%55u"));

        //通过歌手名去搜索专辑
        String key = "金泰妍";
        int page = 1;
        int size = 30;
        String text = "{\"s\":\"" + key + "\",\"type\":10,\"offset\":" + (page - 1) * size + ",\"limit\":" + size + ",\"total\":true}";
        System.out.println(text);
        String s = NetUtil.GetEncHtml(HOST, text, true);
        System.out.println(s);

        //通过歌手名去搜索mv
        String text1 = "{\"s\":\"" + key + "\",\"type\":1004,\"offset\":" + (page - 1) * size + ",\"limit\":" + size + ",\"total\":true}";
        String t = NetUtil.GetEncHtml(HOST, text1, true);
        System.out.println(t);
        //由上可以发现变化的仅仅是type值，
        // 10===通过歌手搜索专辑，
        // 1004===mv，
        // 1000===该歌手歌单（用户创建）
        // 100 === 搜索歌手
        // 1009 === 主播电台

    }
}

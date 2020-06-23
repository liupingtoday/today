package cn.js.today.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple to Introduction
 *
 * @Description: 一句话描述该类的功能
 * @Author: liuping
 * @Since 2020-03-30
 * @UpdateUser: liuping
 * @UpdateDate: 2020-03-30
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 */
public class FfprobeUtils {
    private static String ENCODING = "UTF-8";

    public static String exeOSCommond(String[] comm) throws AgentEngineException
    {
        Process myproc = null;
        BufferedReader buf = null ;
        StringBuffer sb = new StringBuffer();
        try
        {
            myproc = Runtime.getRuntime().exec(comm);
            try
            {
                // 等待执行完再往后执行
                //myproc.waitFor();删除，可能会引起jvm缓冲区写满导致阻塞
                buf = new BufferedReader(new InputStreamReader(
                        myproc.getInputStream(),ENCODING), 1024);

                String str = "";
                while ((str = buf.readLine()) != null)
                {
                    sb.append(str);
                }
            } catch (Exception e)
            {
                throw new AgentEngineException(String.format(
                        "execute command [%s] Exception!", StringUtils.join(
                                comm, ' ')), e);
            }
        } catch (IOException e)
        {
            throw new AgentEngineException(String.format(
                    "execute command [%s] Exception!", StringUtils.join(comm,
                            ' ')), e);
        }
        finally
        {
            if (null != buf)
                try
                {
                    buf.close();
                } catch (IOException e)
                {
                }
            if(null != myproc)
                myproc.destroy();
        }

        return sb.toString();
    }

    /**
     *   //ffprobe -v quiet -print_format json -show_format -show_streams
     * @param ffprobePath    ffprobe文件的绝对路径
     * @param path       file.getAbsolutePath()
     * @return
     */
    public static String ffprobeJson(String ffprobePath, String path) {
        if(path != null) {
            String[] comm = new String[8];
            comm[0] = ffprobePath;
            comm[1] = "-v";
            comm[2] = "quiet";
            comm[3] = "-print_format";
            comm[4] = "json";
            comm[5] = "-show_format";
            comm[6] = "-show_streams";
            comm[7] = path;

            try {
                return exeOSCommond(comm);
            } catch (AgentEngineException e) {
                e.printStackTrace();

                return "{success:false}";
            }
        }
        return "{success:false}";
    }
}

package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-11-23 10:12
 */

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Sendinfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class MessagingController {


    @RequestMapping("/smsss")
    @ResponseBody
    public Map Companyselect(HttpServletResponse response)throws Exception {
        Map map = new HashMap<String, Object>();
        response.setHeader("Access-Control-Allow-Origin", "*");
        String weinxinhao="oRSZoszThc2q_vZrutZdJlC5MZHU";//微信的编号
        String shoujihao="15137858762";//手机号码
        //像微信公众号发消息
//        Sendinfo s=new Sendinfo();//调用封装
//       String tokeTest= s.getAccess_token("wx0657d7c14620581c","cafbeb95c7a4709f4e128d01b314fa3b");//微信api 固定写法
//       JSONObject  jsonObject1= JSONObject.fromObject(tokeTest.toString());//微信api 固定写法
//       String groupUrl1 = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+jsonObject1.get("access_token");//微信api 固定写法
//        String OpenId =weinxinhao;//赋值 要不要无所谓看个人
//        String str=null; //微信定义的模板
//        String smsM=null;//模板编号
//        str = "您好!您有新的采购订单需要处理！"+'\n'+'\t'+"紧急程度:中等"+'\n'+'\t'+"发送人部门:研发部"+'\n'+'\t'+"发送人姓名:郭帅昌";
//        smsM ="SMS_127153221";//尊敬的name，OA系统有您新的采购订单需处理，请查看
//        System.out.println("---------流程到采购");
//        //start 往Sendinfo 封装勒里面传的参数格式  固定并且微信api 接收的固定格式 根据自己的需求可以更改参数
//        String openid1data1 = "{" + "\"touser\": \"" + OpenId + "\","
//                + "\"msgtype\": \"text\"," + "\"text\": {"
//                + "\"content\": \" " + str + "  \"" + "}" + "}";
//        JSONObject jsonObject =s.httpsRequest1(groupUrl1, "post",openid1data1);
        //end
        //短信发送
      String phone =shoujihao;
        System.out.println("++++++++++++++++此次发送的手机号为"+shoujihao+"柯博");
        String name = "柯博";
        String count = "{\"name\":\""+name+"\"}" ;//模板
        String smsM1="SMS_151770422";//模板
        SendSmsResponse sp =Sendinfo.sendSms(phone,smsM1,count); //start 往Sendinfo 封装勒里面传的参数格式  固定并且阿里云api 接收的固定格式 根据自己的需求可以更改参数
        if(sp.getBizId()==null){
            map.put("a","发送失败");
        }else{
            map.put("a","发送成功");
        }
        return  map;
    }


}

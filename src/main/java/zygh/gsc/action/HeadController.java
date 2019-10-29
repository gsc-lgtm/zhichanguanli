package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-22 11:40
 */

import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.gsc.bean.Head;
import zygh.gsc.bean.User;
import zygh.gsc.dao.HeadMapper;
import zygh.gsc.service.AssetsService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/asset")
public class HeadController {

    @Autowired
    private HeadMapper headMapper;

    @RequestMapping(value ="/Headselect" ,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String select(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        User rootMenu1= headMapper.Headselect123();
        String A=rootMenu1.getUser_level_head();
        String [] result = A.split(",");
        List<Head> rootMenu12332=new ArrayList();

        int[]  intArr = new int[result.length];
        for(int i = 0; i < result.length; i++){
            intArr[i] = Integer.parseInt(result[i]);
        }
        for(int a = 0;a<intArr.length;a++){
            List<Head> rootMenu1233=headMapper.Headselect2(intArr[a]);
            rootMenu12332.add(rootMenu1233.get(0));
        }
        List<Head> rootMenu=headMapper.Headselect();
        List<Head>  menuList=new ArrayList();
        for (int i=0;i<rootMenu12332.size();i++){
            if(rootMenu12332.get(i).getHead_taitou_id()==0){
                menuList.add(rootMenu12332.get(i));
            }
        }
        Iterator iterList= menuList.iterator();
        while (iterList.hasNext()){
            Head treemenu=(Head) iterList.next();
            treemenu.setHeadList(getChild(treemenu.getHead_id(),rootMenu12332));
        }
        GsonBuilder gb =new GsonBuilder();
        gb.disableHtmlEscaping();
        String data=gb.create().toJson(menuList);
        return data;
    }
    private List<Head> getChild(int id, List<Head> rootMenu) {
        List<Head> childList = new ArrayList();
        Iterator iterList= rootMenu.iterator();
        while (iterList.hasNext()){
            Head  treemenu =(Head) iterList.next();
            if(treemenu.getHead_taitou_id()!=0){
                if(treemenu.getHead_taitou_id()==id){
                    childList.add(treemenu);
                }
            }
        }
        Iterator iterList2= childList.iterator();
        while (iterList2.hasNext()){
            Head treemenu=(Head) iterList2.next();
            treemenu.setHeadList(getChild(treemenu.getHead_id(),rootMenu));
        }
        if(childList.size()==0){
            return null;
        }
        return childList;
    }

   /* @RequestMapping(value ="/Headselect" ,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String select(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Head> rootMenu=headMapper.Headselect();
        List<Head>  menuList=new ArrayList();
        for (int i=0;i<rootMenu.size();i++){
            if(rootMenu.get(i).getHead_taitou_id()==0){
                menuList.add(rootMenu.get(i));
            }
        }
        Iterator iterList= menuList.iterator();
        while (iterList.hasNext()){
            Head treemenu=(Head) iterList.next();
            treemenu.setHeadList(getChild(treemenu.getHead_id(),rootMenu));
        }
        GsonBuilder gb =new GsonBuilder();
        gb.disableHtmlEscaping();
        String data=gb.create().toJson(menuList);
        return data;
    }
    private List<Head> getChild(int id, List<Head> rootMenu) {
        List<Head> childList = new ArrayList();
        Iterator iterList= rootMenu.iterator();
        while (iterList.hasNext()){
            Head  treemenu =(Head) iterList.next();
            if(treemenu.getHead_taitou_id()!=0){
                if(treemenu.getHead_taitou_id()==id){
                    childList.add(treemenu);
                }
            }
        }
        Iterator iterList2= childList.iterator();
        while (iterList2.hasNext()){
            Head treemenu=(Head) iterList2.next();
            treemenu.setHeadList(getChild(treemenu.getHead_id(),rootMenu));
        }
        if(childList.size()==0){
            return null;
        }
        return childList;
    }
*/

}

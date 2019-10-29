package zygh.gsc.action;/*
	公司：中裕广恒科技股份有限公司
	项目：zhichanguanli
	编程人员：研发部郭帅昌
	时间： 2018-10-26 18:20
 */

import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.biff.RowsExceededException;
import  jxl.write.WritableFont;
import jxl.write.biff.WritableFonts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zygh.gsc.bean.Company;
import zygh.gsc.bean.RepairOrders;
import zygh.gsc.dao.RepairOrdersMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

@Controller
@RequestMapping("/asset")
public class RepairOrdersController {

    @Autowired
    private RepairOrdersMapper repairOrdersMapper;


    /**
     * 查询出所属系统
     *
     * @param [response]
     * @return java.util.Map<java.lang.String                               ,                               java.util.List                               <                               java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    @RequestMapping("/selectCom")
    @ResponseBody
    public Map selectCom(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List selectCom = repairOrdersMapper.selectCom();
        map.put("selectCom", selectCom);
        return map;
    }

    /**
     * 查询所属子系统
     *
     * @param name
     * @param response
     * @return
     */
    @RequestMapping("/selectsubsystem")
    @ResponseBody
    public Map<String, List<Object>> selectsubsystem(String name, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List selectsubsystem = repairOrdersMapper.selectsubsystem(name);
        map.put("selectsubsystem", selectsubsystem);
        return map;
    }

    /**
     * 查询分配公司小组成员
     *
     * @param response
     * @return
     */

    @RequestMapping("/selectCompany")
    @ResponseBody
    public Map<String, List<Object>> selectCompany(String name, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List selectCompany = repairOrdersMapper.selectCompany(name);
        map.put("selectCompany", selectCompany);
        return map;
    }

    /**
     * 发布工单
     *
     * @param repairOrders
     * @param response
     * @return
     */

    @RequestMapping("/insertRepairorders")
    @ResponseBody
    public int insertRepairorders(RepairOrders repairOrders, int orders_id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        repairOrdersMapper.updatestate(orders_id);
        int c = repairOrdersMapper.insertRepairorders(repairOrders);
        return c;
    }

    /* *
     *  添加附件
     *
     * @author 研发部郭帅昌
     * @date 2018/8/20 13:39
     * @param [files, repository, response, request]
     * @return void
     */
    @RequestMapping("/addRepository")
    public void addRepository(@RequestParam(value = "files")/*从后台获取数据*/List<MultipartFile> files, HttpServletResponse response, HttpServletRequest request) {
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("1123132");
        //定义一个集合保存所有的文件名
        List<String> fileNameList = new ArrayList<String>();
        //定义一个集合保存所有的文件内容
        List<String> contentList = new ArrayList<String>();
        if (!files.isEmpty() && files.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : files) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                StringBuilder sb = new StringBuilder(originalFilename);
                // 设置上传文件的保存地址目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
                String newFilename = originalFilename +
                        "_" + UUID.randomUUID();
                //将文件名加入到集合中
                fileNameList.add(newFilename);
                //将文件内容加入到集合中
                contentList.add(originalFilename);
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath + newFilename));
                    System.out.println(dirPath + newFilename);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 查询所以的分配工单
     *
     * @param [response]
     * @return java.util.Map<java.lang.String                               ,                               java.util.List                               <                               java.lang.Object>>
     * @author 研发部郭帅昌
     * @date 2018/8/21 17:09
     */

    @RequestMapping("/selectRepairOrders")
    @ResponseBody
    public Map<String, List<Object>> selectRepairOrders(String name, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List selectRepairOrders = repairOrdersMapper.selectRepairOrders(name);
        map.put("selectRepairOrders", selectRepairOrders);
        return map;
    }

    /**
     * 接单后 根据id 填写原因 以及更改 接单变为处理中
     *
     * @param repair_completiontime
     * @param repair_id
     * @param response
     * @return
     */
    @RequestMapping("/updateRepairOrders")
    @ResponseBody
    public int updateRepairOrders(String repair_completiontime, String repair_eventhandler, int repair_id, String repair_note, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        int selectRepairOrders = repairOrdersMapper.updateRepairOrders(repair_completiontime, repair_id, repair_eventhandler, repair_note);
        return selectRepairOrders;
    }

    /**
     * 接单后 根据id 填写原因 以及更改 处理中变为处理完成
     *
     * @param repair_id
     * @param repair_completiondate
     * @param repair_eventreason
     * @param repair_dealresults
     * @param response
     * @return
     */
    @RequestMapping("/updateRepairOrdersResults")
    @ResponseBody
    public int updateRepairOrdersResults(int repair_id, String repair_completiondate, String repair_eventreason, String repair_dealresults, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        int updateRepairOrdersResults = repairOrdersMapper.updateRepairOrdersResults(repair_id, repair_completiondate, repair_eventreason, repair_dealresults);
        return updateRepairOrdersResults;
    }


    @RequestMapping("/Selectdealwith")
    @ResponseBody
    public Map Selectdealwith(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map map = new HashMap<String, Object>();
        List<Company> selectdealwithCompany = repairOrdersMapper.selectdealwithCompany();
        List list = new ArrayList();
        for (int a = 0; a < selectdealwithCompany.size(); a++) {
            List<RepairOrders> selectdealwith = repairOrdersMapper.Selectdealwith(selectdealwithCompany.get(a).getC_name());
            System.out.println(selectdealwith.size());
            System.out.println(selectdealwith);
            if (selectdealwith.size() == 0) {
                continue;
            } else if (selectdealwith.size() != 0) {
                list.add(selectdealwith);
            }
        }
        map.put("selectdealwith", list);
        return map;
    }


    /**
     * 打印excel
     */

    @RequestMapping("/export")//导出考勤
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws RowsExceededException, WriteException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");


        File file = new File("E:/123/智能交通运维故障修复报表.xls");
        try {
            file.createNewFile();
            WritableWorkbook wwb = Workbook.createWorkbook(file);
            WritableSheet ws = wwb.createSheet("sheet1", 0);
//            ws.setRowView(0, 600); // 设置行的高度
//            ws.setColumnView(0, 300); // 设置列的宽度
//            ws.setColumnView(1, 200); // 设置列的宽度
            //start设置每列的宽度

            //start 合并单元格（左上列，左上行，右下列，右下行）
//            ws.mergeCells(0, 0, 10, 0);
            ws.mergeCells(0, 0, 10, 0);
            Label sheetTitle = new Label(0, 0, "智能交通运维故障修复进度表（已修复）",getHeaderCellStyle(18));
            ws.addCell(sheetTitle);

//            ws.mergeCells(11, 0, 20, 0);
//            Label sheetTitle1 = new Label(11, 0, "智能交通运维故障修复进度表（已修复）",getHeaderCellStyle(18));
//            ws.addCell(sheetTitle1);
            //end 合并单元格（左上列，左上行，右下列，右下行）

            Label labelUserId = new Label(0, 1, "序号");
            ws.setRowView(100,100);
            ws.addCell(labelUserId);
            Label labelUserName = new Label(1, 1, "点位地址");
            ws.addCell(labelUserName);
            Label labelSecName = new Label(2, 1, "设备类型");
            ws.addCell(labelSecName);
            Label labelCheckMorning = new Label(3, 1, "设备小类");
            ws.addCell(labelCheckMorning);
            Label labelCheckNight = new Label(4, 1, "工单状态");
            ws.addCell(labelCheckNight);
            Label labelAt_attendance = new Label(5, 1, "运维公司");
            ws.addCell(labelAt_attendance);
            Label labelAt_their_allocated = new Label(6, 1, "运维公司负责人");
            ws.addCell(labelAt_their_allocated);
            Label labelAt_leave = new Label(7, 1, "结案时间");
            ws.addCell(labelAt_leave);
            Label labelAt_late = new Label(8, 1, "处理描述");
            ws.addCell(labelAt_late);
            Label labelAt_leave_early = new Label(9, 1, "责任公司");
            ws.addCell(labelAt_leave_early);
            Label labelAt_business = new Label(10, 1, "处理方案");
            ws.addCell(labelAt_business);
            int c = 0;
            List<Company> selectdealwithCompany = repairOrdersMapper.selectdealwithCompany();
            for (int a=0;a<selectdealwithCompany.size();a++) {
                int q=0;
                List<RepairOrders> selectdealwith = repairOrdersMapper.Selectdealwith(selectdealwithCompany.get(a).getC_name());
                if(selectdealwith.size()==0){
                    q=q-1;
                   continue;
                }else{
                    //start 合并单元格（左上列，左上行，右下列，右下行）
                    ws.mergeCells(0, q+2+c, 10, q+2+c);
                    Label sheetTitle12 = new Label(0, q+2+c, "责任公司:" + " " +selectdealwithCompany.get(a).getC_name(),getHeaderCellStyle(10));
                    ws.addCell(sheetTitle12);
                    //end 合并单元格（左上列，左上行，右下列，右下行）
                }
                    q++;
                for ( int i = 0; i < selectdealwith.size(); i++) {
                    //序号
                    Label Repair_id = new Label(0, 2+c+1, selectdealwith.get(i).getRepair_id()+"");
                    ws.addCell(Repair_id);
                    // 点位地址
                    Label repair_facilities = new Label(1, 2+c+1, selectdealwith.get(i).getRepair_facilities());
                    ws.addCell(repair_facilities);

                    String [] repair_eventreason=selectdealwith.get(i).getRepair_facilities().split("[,\\，]");
                    // 设备类型
                    Label repair_subsystem = new Label(2, 2+c+1,repair_eventreason[0]);
                    ws.addCell(repair_subsystem);
                    // 设备小类
                    Label repair_Date = new Label(3, 2+c+1, repair_eventreason[1]);
                    ws.addCell(repair_Date);
                    // 工单状态
                    Label repair_level = new Label(4, 2+c+1, selectdealwith.get(i).getRepair_level());
                    ws.addCell(repair_level);
                    // 运维公司
                    Label repair_processing = new Label(5, 2+c+1, selectdealwith.get(i).getRepair_processing());
                    ws.addCell(repair_processing);
                    // 运维公司负责人
                    Label repair_head = new Label(6, 2+c+1, selectdealwith.get(i).getRepair_head());
                    ws.addCell(repair_head);
                    // 结案时间
                    Label repair_completiondate = new Label(7, 2+c+1, selectdealwith.get(i).getRepair_completiondate());
                    ws.addCell(repair_completiondate);
                    // 处理描述
                    Label repair_dealresults = new Label(8, 2+c+1, selectdealwith.get(i).getRepair_dealresults());
                    ws.addCell(repair_dealresults);
                    // 责任公司
                    Label repair_processing1 = new Label(9, 2+c+1, selectdealwith.get(i).getRepair_processing());
                    ws.addCell(repair_processing1);
                    // 处理方案
                    Label plan = new Label(10, 2+c+1, "继续关注跟踪");
                    ws.addCell(plan);
                    c++;
                }
            }
            wwb.write();
            wwb.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 表头单元格样式的设定
     */
    public WritableCellFormat getHeaderCellStyle(int a){

        /*
         * WritableFont.createFont("宋体")：设置字体为宋体
         * 10：设置字体大小
         * WritableFont.BOLD:设置字体加粗（BOLD：加粗     NO_BOLD：不加粗）
         * false：设置非斜体
         * UnderlineStyle.NO_UNDERLINE：没有下划线
         */
          WritableFont font = new WritableFont(WritableFont.createFont("宋体"), a, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);

        WritableCellFormat headerFormat = new WritableCellFormat(NumberFormats.TEXT);
        try {
            //添加字体设置
            headerFormat.setFont(font);
            //设置单元格背景色：表头为黄色
            headerFormat.setBackground(Colour.YELLOW);
            //设置表头表格边框样式
            //整个表格线为粗线、黑色
           headerFormat.setBorder(Border.ALL, BorderLineStyle.THICK, Colour.BLACK);
            //表头内容水平居中显示
            headerFormat.setAlignment(Alignment.CENTRE);
        } catch (WriteException e) {
            System.out.println("表头单元格样式设置失败！");
        }
        return headerFormat;
    }


}

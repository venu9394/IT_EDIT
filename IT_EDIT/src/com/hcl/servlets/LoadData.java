package com.hcl.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hcl.util.Util;

 
public class LoadData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoadData() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 
		 String Type=request.getParameter("Type");  
		 String Employeeid=request.getParameter("employeeid");
		 
		 String financialyear=request.getParameter("financialyear");
		 
		 System.out.println(financialyear);
		 
		//Type="80C-Details";
		 
		response.setContentType("text/html");
		 
		StringBuffer Query1=new StringBuffer();
		StringBuffer Query2=new StringBuffer();
		
		StringBuffer Query3=new StringBuffer();
		StringBuffer Query4=new StringBuffer();
		
		StringBuffer Query5=new StringBuffer();
		StringBuffer Query6=new StringBuffer();
		StringBuffer Query7=new StringBuffer();
		 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		JSONObject jsonObj = new JSONObject();
		JSONArray values = new JSONArray();
		
		JSONObject jsonObj1= new JSONObject();
		JSONArray values1 = new JSONArray();
		
		
		JSONObject jsonObj2= new JSONObject();
		JSONArray values2 = new JSONArray();
		
		JSONObject jsonObj3= new JSONObject();
		JSONArray values3 = new JSONArray();
		
		
		JSONObject jsonObj5= new JSONObject();
		JSONArray values5 = new JSONArray();
		
		JSONObject jsonObj6= new JSONObject();
		JSONArray values6 = new JSONArray();
		
		JSONObject jsonObj7= new JSONObject();
		JSONArray values7 = new JSONArray();
		
		 con = Util.getConnection();
		 
		 
			 
		if(Type.equalsIgnoreCase("80C-Details")){
	
			Query1.append("SELECT B.RefNo, B.EMPLOYEEID,B.MFD,B.PUBLICPF, B.FDs, B.POSAVINGS, "
					+ "B.NATIONALSAVINGCERTIFICATES,  B.UNIT_LIP, B.LIFE_IPS, B.PRINCIPAL_HOUSINGLOAN,"
					+ "B.EQUITYLINKED_SAVINGS, B.TAX_SAVINGBONDS, B.SUKANYA_SAMRIDDI,"
					+ "B.CPSCG, B.TUITION_FEE_KIDS,B.OTHERS, B.FINAL_80C "
					+ "FROM test.tbl_it_emp_80c_others B "
					+ "where B.refno = (select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy in ('"+financialyear+"')) and B.employeeid="+Employeeid+" ");
		
			System.out.println(Query1.toString());
					//+ "SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
		
	
			Query2.append("SELECT B.POLICYNO, B.FOR_RELATION, B.POLICY_AMOUNT, "
					+ "B.TOTAL_PREMIUM, B.FINAL_TOTAL "
					+ "FROM test.tbl_it_emp_80c_details B WHERE "
					+ "B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy IN ('"+financialyear+"'))  and B.employeeid="+Employeeid+" ");
					//(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
			
			System.out.println(Query2.toString());	
			
		
			Query3.append("SELECT B.PHC,if(B.S80DD=0,'Selectlimit',if(B.S80DD=75000,'80DD_limit1',if(B.S80DD=125000,'80DD_limit2',B.S80DD))) S80DD,"
					+ "B.S80DD1, B.S80DD2,IF(B.S80DDB=0,'Selectlimit',IF(B.S80DDB=40000,'80DDB_limit1',IF(B.S80DDB=100000,'80DDB_limit2',B.S80DDB))) S80DDB, B.S80DDB1,"
					+ " B.S80DDB2,if(B.S80U=0,'Selectlimit',if(B.S80U=75000,'80U_limit1',if(B.S80U=125000,'80U_limit2',B.S80U))) S80U, B.S80U1, B.S80U2, B.S80E, B.S80CCG,B.S80CCG1, B.S80CCG2, B.S80TTA,B.S80TTA1, "
					+ "B.S80G,IF(B.S80G_NAME = CONVERT(0, CHAR(10)),'Select Organization',CONCAT(B.S80G,'~',B.S80G_NAME)) S80G_NAME, B.S80G_AMT, B.TOTAL_80D FROM test.tbl_it_emp_80d_others  B "
					+ "WHERE B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy IN ('"+financialyear+"'))  and B.employeeid="+Employeeid+" ");
					//(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
				
		//	System.out.println(Query3);	
			
			Query4.append("SELECT B.POLICYNO, B.FOR_RELATION, B.CITIZEN, B.POLICY_AMOUNT, B.TOTAL_PREMIUM, B.FINAL_TOTAL FROM test.tbl_it_emp_80d_details B "
					+ "WHERE B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+""
					+ " and fy IN ('"+financialyear+"')) and B.employeeid="+Employeeid+"");
					//(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
			
			System.out.println(Query4.toString());
			
			Query5.append("SELECT B.ADDRESS,B.PAN,B.RENTAMT,B.OHLBANK,B.OHLAMT,B.OHLDATE,B.OHLPAMT,B.OHLIAMT,B.LETOUT,"
					+ "B.MTP,B.S80EE,B.HOUSETYPE,B.OTHERINCOME,IF(IFNULL(b.ACTUALCOST,'0')='0','0',IFNULL(b.ACTUALCOST,'0')) ACTUALCOST,b.OHLIAMT,"
					+ "b.FIRSTLOAN,b.ISCONSTRUCTION "
					+ " FROM test.tbl_it_emp_renthouse  B "
					+ "where B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy IN ('"+financialyear+"'))  ");
					//(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
			
			System.out.println(Query5.toString());
			
			Query6.append("SELECT B.NOOFKIDS,B.KIDNAME,B.CLASS,B.SCHOOL_NAME FROM test.tbl_it_emp_kids_exemption B "
					+ "WHERE B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy IN ('"+financialyear+"')) and B.employeeid="+Employeeid+" ");
					//(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
			
			System.out.println(Query6.toString());	
			
			Query7.append("SELECT  B.DFROM, B.DTO, B.TFROM, B.TTO, B.NAME, B.RELATION, B.TMODE, B.ESTIMAMT, B.SUM "
					+ "FROM test.tbl_it_emp_lta B WHERE B.REFNO=(select max(refno) from test.tbl_emp_it_tds where employeeid="+Employeeid+" "
					+ "and fy IN ('"+financialyear+"'))  and and B.employeeid="+Employeeid+" ");
				// "(SELECT CASE WHEN MONTH(CURDATE())<=3 THEN CONCAT(YEAR(CURDATE())-1, '-',YEAR(CURDATE())) ELSE CONCAT(YEAR(CURDATE()),'-', YEAR(CURDATE())+1) END))");
			System.out.println(Query7.toString());	
			
			try{
				 ps = con.prepareStatement(Query1.toString());
	             rs = ps.executeQuery();
	             if (rs.next()) {

	            	 
	            	 jsonObj.put("MFD", rs.getString("MFD"));
	            	 jsonObj.put("PUBLICPF",rs.getString("PUBLICPF"));
	            	 jsonObj.put("FDs", rs.getString("FDs"));
	            	 jsonObj.put("POSAVINGS",rs.getString("POSAVINGS"));
	            	 jsonObj.put("NATIONALSAVINGCERTIFICATES",rs.getString("NATIONALSAVINGCERTIFICATES"));
	            	 jsonObj.put("UNIT_LIP",rs.getString("UNIT_LIP"));
	            	 jsonObj.put("LIFE_IPS",rs.getString("LIFE_IPS"));
	            	 jsonObj.put("PRINCIPAL_HOUSINGLOAN",rs.getString("PRINCIPAL_HOUSINGLOAN"));
	            	 jsonObj.put("EQUITYLINKED_SAVINGS",rs.getString("EQUITYLINKED_SAVINGS"));
	            	 jsonObj.put("TAX_SAVINGBONDS",rs.getString("TAX_SAVINGBONDS"));
	            	 jsonObj.put("SUKANYA_SAMRIDDI",rs.getString("SUKANYA_SAMRIDDI"));
	            	 jsonObj.put("CPSCG",rs.getString("CPSCG"));
	            	 jsonObj.put("TUITION_FEE_KIDS",rs.getString("TUITION_FEE_KIDS"));
	            	 jsonObj.put("OTHERS",rs.getString("OTHERS"));
	            	 jsonObj.put("FINAL_80C",rs.getString("FINAL_80C"));
	            	
	            	 
	            	 values.add(jsonObj);
	            	 
	             }
	             
	             ps = con.prepareStatement(Query2.toString());
	             rs = ps.executeQuery();
	             while (rs.next()) {
			
	            	 jsonObj1.put("POLICYNO", rs.getString("POLICYNO"));
	                 jsonObj1.put("FOR_RELATION",rs.getString("FOR_RELATION"));
	                 jsonObj1.put("POLICY_AMOUNT",rs.getString("POLICY_AMOUNT"));
	                 jsonObj1.put("TOTAL_PREMIUM",rs.getString("TOTAL_PREMIUM"));
	                 jsonObj1.put("FINAL_TOTAL",rs.getString("FINAL_TOTAL"));
	                 
	                 values1.add(jsonObj1);
	            	 
	             }

	             DecimalFormat df2 = new DecimalFormat("#.##");       
	             ps = con.prepareStatement(Query3.toString());
	             rs = ps.executeQuery();
	             

	         
	             if(rs.next()) {

	            	jsonObj2.put("PHC", df2.format(rs.getDouble("PHC")));
	            	jsonObj2.put("S80DD",rs.getString("S80DD"));
	            	jsonObj2.put("S80DD1",  df2.format(rs.getDouble("S80DD1")));
	            	jsonObj2.put("S80DD2", df2.format(rs.getDouble("S80DD2")));
	            	jsonObj2.put("S80DDB",rs.getString("S80DDB"));
	            	jsonObj2.put("S80DDB1", df2.format(rs.getDouble("S80DDB1")));
	            	jsonObj2.put("S80DDB2",rs.getString("S80DDB2"));
	            	jsonObj2.put("S80U",rs.getString("S80U"));
	            	
	           // 	System.out.println(rs.getString("S80U"));
	            	jsonObj2.put("S80U1",df2.format(rs.getDouble("S80U1")));
	            	jsonObj2.put("S80U2",df2.format(rs.getDouble("S80U2")));
	            	jsonObj2.put("S80E",df2.format(rs.getDouble("S80E")));
	            	jsonObj2.put("S80CCG",df2.format(rs.getDouble("S80CCG")));
	            	jsonObj2.put("S80CCG1",df2.format(rs.getDouble("S80CCG1")));
	            	jsonObj2.put("S80CCG2",df2.format(rs.getDouble("S80CCG2")));
	            	jsonObj2.put("S80TTA",df2.format(rs.getDouble("S80TTA")));
	            	jsonObj2.put("S80TTA1",df2.format(rs.getDouble("S80TTA1")));
	            	jsonObj2.put("S80G",rs.getString("S80G"));
	            	jsonObj2.put("S80G_NAME",rs.getString("S80G_NAME"));
	            	jsonObj2.put("S80G_AMT",df2.format(rs.getDouble("S80G_AMT")));
	            	jsonObj2.put("TOTAL_80D",df2.format(rs.getDouble("TOTAL_80D")));
	            	 
	            	 values2.add(jsonObj2);
	            	 
	             }
	             
	             ps = con.prepareStatement(Query4.toString());
	             rs = ps.executeQuery();
	             while (rs.next()) {
	 			
	            	jsonObj3.put("POLICYNO", rs.getString("POLICYNO"));
	             	jsonObj3.put("FOR_RELATION",rs.getString("FOR_RELATION"));
	             	jsonObj3.put("CITIZEN",rs.getString("CITIZEN"));
	             	jsonObj3.put("POLICY_AMOUNT",rs.getString("POLICY_AMOUNT"));
	             	jsonObj3.put("TOTAL_PREMIUM",rs.getString("TOTAL_PREMIUM"));
	             	jsonObj3.put("FINAL_TOTAL",rs.getString("FINAL_TOTAL"));
	                
	                 values3.add(jsonObj3);
	            	 
	             }
	             
	             
	             ps = con.prepareStatement(Query5.toString());

	             rs = ps.executeQuery();
	             if(rs.next()) {
	 			//System.out.println("5");
	             	
	             	// ADDRESS, PAN, RENTAMT, OHLBANK, OHLAMT, OHLDATE, OHLPAMT, OHLIAMT, LETOUT, MTP, S80EE, STATUS, HOUSETYPE, OTHERINCOME,  
	            	 
	            	 jsonObj5.put("ADDRESS", rs.getString("ADDRESS"));
	            	 jsonObj5.put("PAN",rs.getString("PAN"));
	            	 jsonObj5.put("RENTAMT", rs.getString("RENTAMT"));
	            	 jsonObj5.put("OHLBANK",rs.getString("OHLBANK"));
	            	 jsonObj5.put("OHLAMT",rs.getString("OHLAMT"));
	            	 jsonObj5.put("OHLDATE",rs.getString("OHLDATE"));
	            	 jsonObj5.put("OHLPAMT",rs.getString("OHLPAMT"));
	            	 jsonObj5.put("LETOUT",rs.getString("LETOUT"));
	            	 jsonObj5.put("MTP",rs.getString("MTP"));
	            	 jsonObj5.put("S80EE",rs.getString("S80EE"));
	            	 jsonObj5.put("HOUSETYPE",rs.getString("HOUSETYPE"));
	            	 jsonObj5.put("OTHERINCOME",rs.getString("OTHERINCOME"));
	            	 jsonObj5.put("ACTUALCOST",rs.getString("ACTUALCOST"));
	            	 jsonObj5.put("OHLIAMT",rs.getString("OHLIAMT"));
	            	 jsonObj5.put("FIRSTLOAN",rs.getString("FIRSTLOAN"));
	            	 jsonObj5.put("ISCONSTRUCTION",rs.getString("ISCONSTRUCTION"));
	            	 
	            	 
	            	 values5.add(jsonObj5);
	            	 
	             }
	             
	      /*       jsonObj1.put("NODATA", "NODATA");
	            
	            
	             values1.add(jsonObj1);*/
	             
	         	ps = con.prepareStatement(Query6.toString());
		//		System.out.println(ps.toString());
	            rs = ps.executeQuery();
	            while(rs.next()) {
				//System.out.println("5");
	            	//NOOFKIDS, KIDNAME, CLASS, SCHOOL_NAME
	           	 
	            	jsonObj6.put("NOOFKIDS", rs.getString("NOOFKIDS"));
	            	jsonObj6.put("KIDNAME",rs.getString("KIDNAME"));
	            	jsonObj6.put("CLASS", rs.getString("CLASS"));
	            	jsonObj6.put("SCHOOL_NAME",rs.getString("SCHOOL_NAME"));
	           	 
	           	 
	           	 values6.add(jsonObj6);
	           	 
	            }
	            
//	            jsonObj1.put("NODATA", "NODATA");
//	            
//	            
//	            values1.add(jsonObj1);  
	             
	            ps = con.prepareStatement(Query7.toString());
		//		System.out.println(ps.toString());
	            rs = ps.executeQuery();
	            while(rs.next()) {
				 
	           	 jsonObj7.put("DFROM", rs.getString("DFROM"));
	           	jsonObj7.put("DTO",rs.getString("DTO"));
	           	jsonObj7.put("TFROM", rs.getString("TFROM"));
	           	jsonObj7.put("TTO",rs.getString("TTO"));
	           	jsonObj7.put("NAME",rs.getString("NAME"));
	           	jsonObj7.put("RELATION", rs.getString("RELATION"));
	           	jsonObj7.put("TMODE",rs.getString("TMODE"));
	           	jsonObj7.put("ESTIMAMT", rs.getString("ESTIMAMT"));
	           	jsonObj7.put("SUM",rs.getString("SUM"));
	           	 
	           	values7.add(jsonObj7);
	           	 
	            }    
	             
			}catch(Exception Er){
			//	dataflag=false;
				System.out.println("Error AT::" +Er);
			   
				 
			}
			
		}			
		 //out.write("data"+values1.toString());
		// out.write(values.toString());
		response.setContentType("application/json"); 
   	    response.setCharacterEncoding("utf-8"); 
		String bothJson = "["+(values.toString())+","+(values1.toString())+","+(values2.toString())+","+(values3.toString())+","+(values5.toString())+","+(values6.toString())+","+(values7.toString())+"]"; //Put both objects in an array of 2 elements
		
		//System.out.println(bothJson+"----------");
		response.getWriter().write(bothJson);
		 
	}

}

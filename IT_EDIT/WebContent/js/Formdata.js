
responseData=null;

function myFunction()
	{


	 var employeeid=$("#emp_id").val();
	 
	 
	 var financialyear=$('#financialyear').val();
	// alert(financialyear);
	 
	/*    document.getElementById("rentonly").checked = true;
        document.getElementById("rentonly1").checked = false;
        document.getElementById("rentonly2").checked = false;
			//alert("data"+responseData[1].length);
			
    	housing('rent');*/
	 
		 try {
				 
				$.ajax({
					type : "get",
					url : "LoadData",
					 cache: false,
					data:{employeeid:employeeid,Type:"80C-Details",financialyear:financialyear},
					success : function(responseData, textStatus, jqXHR) {
					//	alert(responseData[0].length+"<1>"+responseData[2].length+"<2>"+responseData[4].length);

				//		alert(JSON.stringify(responseData[1])+":::::::::::::::::::"+responseData[1].length);
						
						 var my_json = responseData[6];
						
						 var my_json5 = responseData[5];
						 
						 
						if(responseData[0].length==0 )
			    		{
						//	alert("0123");
							
							
							$('#80c_pf_estimate').val('0');
							$('#80c_tution_estimate').val('0');
							//  $('#FF0005').val($scope.temp.LIFE_IPS);////Life Insurance Premium
							$('#80c_hl_estimate').val('0');
							$('#80c_nsc_estimate').val('0');
							$('#80c_post_estimate').val('0');
							$('#80c_ul_estimate').val('0');
							$('#80c_eq_estimate').val('0');
							$('#80ccc_licp_estimate').val('0');
							$('#80ccd_pscg_estimate').val('0');
							$('#80c_sss_estimate').val('0');
							$('#80c_fd_estimate').val('0');
							$('#80c_mf_estimate').val('0');
							$('#80c_bond_estimate').val('0');
							$('#80c_others_estimate').val('0');
							$('#80C_final').val('0');
							$('#FF0005').val('0');	
							
//							
//					      

			    		}else if(responseData[0].length==1 ){
			    			
			    		//	alert('2');
							var data=JSON.stringify(responseData[0]);
							var data_1 = data.replace("[", "").replace("]", "");
							var  jsondata_1 = JSON.parse(data_1);

							   $('#80c_pf_estimate').val(jsondata_1.PUBLICPF);
			    			    $('#80c_tution_estimate').val(jsondata_1.TUITION_FEE_KIDS);
			    			  //  $('#FF0005').val($scope.temp.LIFE_IPS);////Life Insurance Premium
			    			    $('#80c_hl_estimate').val(jsondata_1.PRINCIPAL_HOUSINGLOAN);
			    			    $('#80c_nsc_estimate').val(jsondata_1.NATIONALSAVINGCERTIFICATES);
			    			    $('#80c_post_estimate').val(jsondata_1.POSAVINGS);
			    			    $('#80c_ul_estimate').val(jsondata_1.UNIT_LIP);
			    			    $('#80c_eq_estimate').val(jsondata_1.EQUITYLINKED_SAVINGS);
			    				$('#80ccc_licp_estimate').val(jsondata_1.LIFE_IPS);
			    				$('#80ccd_pscg_estimate').val(jsondata_1.CPSCG);
			    				$('#80c_sss_estimate').val(jsondata_1.SUKANYA_SAMRIDDI);
			    				$('#80c_fd_estimate').val(jsondata_1.FDs);
			    	            $('#80c_mf_estimate').val(jsondata_1.MFD);
			    				$('#80c_bond_estimate').val(jsondata_1.TAX_SAVINGBONDS);
			    				$('#80c_others_estimate').val(jsondata_1.OTHERS);
			    				$('#80C_final').val(jsondata_1.FINAL_80C);
							
			    		}
						
						if(responseData[2].length==0 ){
							
							$('#80d_medical_estimate').val('0');
							$('#80DD').val('Selectlimit');
							$('#80dd_handicapped_estimate').val('0');
							$('#80DDB').val('Selectlimit');
							$('#80ddb_treatment_estimate').val('0');
							$('#80U').val('Selectlimit');
							$('#80u_disability_estimate').val('0');
							$('#80e_eduloan_estimate').val('0');
							$('#80cgg_rgsavings_estimate').val('0');
							$('#80tta_deposit_estimate').val('0');
							$('#org').val('Select Organization');
							$('#donation_estimate').val('0');
						
							
						}else if(responseData[2].length==1){
			    			
			    			
				    		
							var data2=JSON.stringify(responseData[2]);
							var data_2=data2.replace("[", "").replace("]", "");
							var jsondata_2=JSON.parse(data_2);
							
						//	alert(jsondata_2.S80DDB);
							
						//	alert($('#80ddb_treatment_estimate').val(jsondata_2.S80DDB1));
		    				  $('#80d_medical_estimate').val(jsondata_2.PHC);
		    			      $('#80DD').val(jsondata_2.S80DD);
		    			      $('#80dd_handicapped_estimate').val(jsondata_2.S80DD1);
		    			      $('#80DDB').val(jsondata_2.S80DDB);
		    			      $('#80ddb_treatment_estimate').val(jsondata_2.S80DDB1);
		    			      $('#80U').val(jsondata_2.S80U);
		    			      $('#80u_disability_estimate').val(jsondata_2.S80U1);
		    			      $('#80e_eduloan_estimate').val(jsondata_2.S80E);
		    			      $('#80cgg_rgsavings_estimate').val(jsondata_2.S80CCG);
		    			      $('#80tta_deposit_estimate').val(jsondata_2.S80TTA);
		    			      $('#org').val(jsondata_2.S80G_NAME);  
		    			      $('#donation_estimate').val(jsondata_2.S80G_AMT);
		    			      
		    			  //    $('#80DDB').val('Selectlimit');
		    			 //     $('#80U').val('Selectlimit');
							
			    		}
						if(responseData[4].length==0){
							
							$('#address').val('');
							$('#pancard').val('');
							$('#rent_amount').val('');
							$('#other_income_estimate').val('');
							$('#bankname').val('');
							$('#loanamount').val('');
							$('#datepicker').val('');
							$('#principal_amount').val('');
							$('#interest').val('');
							$('#propertyincome').val('');
							$('#muncipaltaxes').val('');
							$('#80ee_interestedu_estimate').val('');
							$('#other_income_estimate').val('0');
							
						}						
			    		else if(responseData[4].length==1)
	    				  {
						
							var data3=JSON.stringify(responseData[4]);
							var  data_3=data3.replace("[", "").replace("]", "");
							var jsondata_3=JSON.parse(data_3);
							
					//		alert(jsondata_3.HOUSETYPE);	 
							
	    			      if(jsondata_3.HOUSETYPE=='rent')
				        	{
				        	 
				        	 document.getElementById("rentonly").checked = true;
				        	 
				        	  housing(jsondata_3.HOUSETYPE);
				        	  
				        	 $('#address').val(jsondata_3.ADDRESS);
					         $('#pancard').val(jsondata_3.PAN);
					         $('#rent_amount').val(jsondata_3.RENTAMT);
					         $('#other_income_estimate').val(jsondata_3.OTHERINCOME);

				        	}
				        
				        
				        else if(jsondata_3.HOUSETYPE=='ownhouse')
				        	{
				        	 
					         document.getElementById("rentonly1").checked = true;
					         
					         housing(jsondata_3.HOUSETYPE);
					         //$('#rentonly1')
					         $('#chkbox_2').prop('checked',jsondata_3.FIRSTLOAN);
					         $('#actualcostbox').prop('checked',jsondata_3.ISCONSTRUCTION);
					         
					         $('#actualcost').val(jsondata_3.ACTUALCOST);
					         $('#interest').val(jsondata_3.OHLIAMT);
					         
					         
					         
				        	 $('#bankname').val(jsondata_3.OHLBANK);
				        	 $('#loanamount').val(jsondata_3.OHLAMT);
				        	 $('#datepicker').val(jsondata_3.OHLDATE);
				        	 $('#principal_amount').val(jsondata_3.OHLPAMT);
				             $('#interest').val(jsondata_3.OHLIAMT);
				        	 $('#propertyincome').val(jsondata_3.LETOUT);
				        	 $('#muncipaltaxes').val(jsondata_3.MTP);
				        	 $('#80ee_interestedu_estimate').val(jsondata_3.S80EE);
				        	 $('#other_income_estimate').val(jsondata_3.OTHERINCOME);
				        	 
				        
				        	
				        	}
				        
				        else if(jsondata_3.HOUSETYPE=='ownhousewithproperty')
				        	{
				        	
				        	
				        	
				        	
	                           document.getElementById("rentonly2").checked = true;
					         
					         housing(jsondata_3.HOUSETYPE);
					         
					         $('#chkbox_2').prop('checked',jsondata_3.FIRSTLOAN);
					         $('#actualcostbox').prop('checked',jsondata_3.ISCONSTRUCTION);
					         
					         $('#actualcost').val(jsondata_3.ACTUALCOST);
					         $('#interest').val(jsondata_3.OHLIAMT);
					         
					         
					         $('#address').val(jsondata_3.ADDRESS);
					         $('#pancard').val(jsondata_3.PAN);
					         $('#rent_amount').val(jsondata_3.RENTAMT);
					         $('#bankname').val(jsondata_3.OHLBANK);
					         $('#loanamount').val(jsondata_3.OHLAMT);
					         $('#datepicker').val(jsondata_3.OHLDATE);
					         $('#principal_amount').val(jsondata_3.OHLPAMT);
					         $('#interest').val(jsondata_3.OHLIAMT);
					         $('#propertyincome').val(jsondata_3.LETOUT);
					         $('#muncipaltaxes').val(jsondata_3.MTP);
					         $('#80ee_interestedu_estimate').val(jsondata_3.S80EE);
					         $('#other_income_estimate').val(jsondata_3.OTHERINCOME);


				        	}	    			       
	    				  }
						
						if(responseData[6].length==0){
						//	alert('alert1');
							   $('#lta').val('yes');

				    		lta_drop();
				    		   
						}else if(responseData[6].length==1){
						
					//	alert('alert2');
							
							
						  
							 $('#lta').val('no');
				    		 
							 lta_drop();
						     ltacalculate();
							 
				    		 $('#lta_estimate').val(my_json[0].ESTIMAMT);
				    	     $('#datepicker1').val(my_json[0].DFROM);
				    	     $('#datepicker2').val(my_json[0].DTO);
			                 $('#place1').val(my_json[0].TFROM);
						     $('#place2').val(my_json[0].TTO);
						     $('#employee_lta').val(my_json[0].NAME);
						     $('#it_select_relation').val(my_json[0].RELATION);
						     $('#it_select_transport').val(my_json[0].TMODE);
						     $('#lta_estimated_amount_1').val(my_json[0].ESTIMAMT);
						     $('#lta_actual_amount_1').val(my_json[0].SUM);  
						     
						     
						  

							
						}else if(responseData[6].length==2){
							
						//	alert("alert3");
							  $('#lta').val('no');
					    		 
							 lta_drop();	
							  ltacalculate();
					    		// $('#lta_estimate').val(my_json[0].ESTIMAMT);
					    	     $('#datepicker1').val(my_json[0].DFROM);
					    	     $('#datepicker2').val(my_json[0].DTO);
				                 $('#place1').val(my_json[0].TFROM);
							     $('#place2').val(my_json[0].TTO);
							     $('#employee_lta').val(my_json[0].NAME);
							     $('#it_select_relation').val(my_json[0].RELATION);
							     $('#it_select_transport').val(my_json[0].TMODE);
							     $('#lta_estimated_amount_1').val(my_json[0].ESTIMAMT);
							     $('#lta_actual_amount_1').val(my_json[0].ESTIMAMT);   
					    		
							    $('#datepicker3').val(my_json[1].DFROM);
							    $('#datepicker4').val(my_json[1].DTO);
							    $('#place1_2').val(my_json[1].TFROM);
							    $('#place2_2').val(my_json[1].TTO);
							    $('#employee_lta_2').val(my_json[1].NAME);
							    $('#it_select_relation_2').val(my_json[1].RELATION);
							    $('#it_select_transport1').val(my_json[1].TMODE);
							    $('#lta_estimated_amount_2').val(my_json[1].ESTIMAMT);
							    $('#lta_actual_amount_2').val(my_json[1].ESTIMAMT);
							    
							    $('#lta_estimate').val(my_json[1].SUM);    
							
						}
						
						
						if(responseData[5].length==0)
			    		 {
			    		   document.getElementById("Nochildren").checked = true;
			    		 }
			    	 
			    	else if(responseData[5].length==1)
			    		 {
			    		
			    		/* document.getElementById("One").checked = true;
			    		 eduloan('1');
			    		$('#child1').val(my_json5[0].KIDNAME);
                       $('#child1_studying').val(my_json5[0].CLASS);
                       $('#child1_school_college').val(my_json5[0].SCHOOL_NAME);*/

			    	try{
			    		 if(my_json5[0].NOOFKIDS==1){
			    			 
			    			 document.getElementById("One").checked = true;
				    		 eduloan('1');
				    		$('#child1').val(my_json5[0].KIDNAME);
	                       $('#child1_studying').val(my_json5[0].CLASS);
	                       $('#child1_school_college').val(my_json5[0].SCHOOL_NAME);
			    			 
			    		 }else{
			    			 
			    			 document.getElementById("Two").checked = true;
				    		 eduloan('2');
				    		 $('#child1').val(my_json5[0].KIDNAME);
	                        $('#child1_studying').val(my_json5[0].CLASS);
	                        $('#child1_school_college').val(my_json5[0].SCHOOL_NAME);
	                        $('#child2').val(my_json5[1].KIDNAME);
			                 $('#child2_studying').val(my_json5[1].CLASS);
					         $('#child2_school_college').val(my_json5[1].SCHOOL_NAME);
				    		 
			    			 
			    		 }
			    	}catch(err){
			    		
			    	}
			    		 
			    		 }
			    	 
			    	
			    	
			    	else if(responseData[5].length==2)
			    		{
			    		
			    		//One
			    		//$('#Two').val()
			    try{
			    		if(my_json5[0].NOOFKIDS==1){
			    			 
			    			 document.getElementById("One").checked = true;
				    		 eduloan('1');
				    		$('#child1').val(my_json5[0].KIDNAME);
	                       $('#child1_studying').val(my_json5[0].CLASS);
	                       $('#child1_school_college').val(my_json5[0].SCHOOL_NAME);
			    			 
			    		 }else{
			    			 
			    			 document.getElementById("Two").checked = true;
				    		 eduloan('2');
				    		 $('#child1').val(my_json5[0].KIDNAME);
	                        $('#child1_studying').val(my_json5[0].CLASS);
	                        $('#child1_school_college').val(my_json5[0].SCHOOL_NAME);
	                        $('#child2').val(my_json5[1].KIDNAME);
			                 $('#child2_studying').val(my_json5[1].CLASS);
					         $('#child2_school_college').val(my_json5[1].SCHOOL_NAME);
				    		 
			    			 
			    		 }
			    		
			    }catch(err){
			    	
			    }
			    		
			    		}  
						
						
						
						
						if(responseData[1].length==0 )
						{	    				  
							$("#dataTable").empty();			     

	    				  }else if(responseData[1].length>0){
	    					//  alert('load');
	    					  loadData(responseData[1]);
	 	 			         
	    				  }
						if(responseData[3].length==0){
							 $("#dataTable1").empty();
						}else if(responseData[3].length>0){
							 loadData1(responseData[3]);
						}
						
						
						
						
						
						
						
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					 
						alert("Error;" + textStatus);
						alert("Error;" + errorThrown);

						alert("jqXHR;" + jqXHR.status);

					}
				});
		 } catch (err) {

				alert(err + ":at Last");
			}
		 
		 
		 
		 
		 
		
		 
		
	/*}*/
}


function loadData(datas){
	
	//alert(datas.length);
	 
	 $("#dataTable").empty();
// $("#dataTable1").empty();
	 document.getElementById("FF0005").value="0";
//	 document.getElementById("FF0015").value="0";
    $.each(datas, function(index, value){
    	
    	
    	try{
    	addRow(value);
    //	alert(value);
    //	addRow_1(value);
    	
    	
    	}catch(err){
    		alert(err.message);
    		
    	}
      
    });

}


function loadData1(datas){
	 
	 $("#dataTable1").empty();
	 document.getElementById("FF0015").value="0";
   $.each(datas, function(index, value){
   	
//   	alert(value+":::@@@@");
   	try{
   		addRow_1(value);
   	}catch(err){
   		alert(err.message);
   		
   	}
     
   });

}
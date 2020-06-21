
export default {
  fields: {
    createdate: "建立时间",
    updatedate: "更新时间",
    createman: "建立人",
    enable: "逻辑有效标志",
    updateman: "更新人",
    trmtrainfillinname: "需求填报",
    trmtrainfillinid: "培训项目部门填报标识",
    trmtrainfillinname2: "需求填报",
    nd: "年度",
    jd: "季度",
    zzdzs: "组织",
    ormorgname: "单位",
    trmdepartname: "培训需求通知",
    ormorgsectorname: "部门",
    shortname: "部门",
    jzrq: "截止时间",
    ormorgid: "组织标识",
    trmtrainfillinid2: "培训项目部门填报标识",
    trmdepartid: "培训需求通知标识",
    ormorgsectorid: "部门标识",
  },
	views: {
		gridview: {
			caption: "培训需求填报",
      		title: "培训需求填报",
		},
		feditview: {
			caption: "培训需求填报",
      		title: "需求填报填报编辑视图",
		},
		fgridview: {
			caption: "培训需求填报",
      		title: "需求填报表格视图",
		},
		pickupgridview: {
			caption: "培训需求填报",
      		title: "培训项目部门填报选择表格视图",
		},
		pickupview: {
			caption: "培训需求填报",
      		title: "培训项目部门填报数据选择视图",
		},
		editview: {
			caption: "培训需求填报",
      		title: "培训需求填报",
		},
		mpickupview: {
			caption: "培训需求填报",
      		title: "培训项目部门填报数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "需求填报", 
			druipart1: "", 
			grouppanel1: "需求填报明细", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训项目部门填报标识", 
			srfmajortext: "需求填报", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmdepartname: "培训需求通知", 
			nd: "年度", 
			jd: "季度", 
			jzrq: "截止时间", 
			ormorgname: "填写单位", 
			ormorgsectorname: "填写部门", 
			trmdepartid: "培训需求通知标识", 
			ormorgsectorid: "部门标识", 
			ormorgid: "组织标识", 
			trmtrainfillinid: "培训项目部门填报标识", 
		},
		uiactions: {
		},
	},
	main_2_form: {
		details: {
			group1: "培训需求填报", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训项目部门填报标识", 
			srfmajortext: "需求填报", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmdepartname: "培训需求通知", 
			ormorgname: "单位", 
			ormorgsectorname: "部门", 
			nd: "年度", 
			jd: "季度", 
			jzrq: "截止时间", 
			trmdepartid: "培训需求通知标识", 
			ormorgsectorid: "部门标识", 
			ormorgid: "组织标识", 
			trmtrainfillinid: "培训项目部门填报标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmdepartname: "培训需求通知",
			zzdzs: "组织",
			shortname: "部门",
			nd: "年度",
			jd: "季度",
			jzrq: "截止时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormorgname_like: "单位(%)", 
			n_ormorgsectorname_like: "部门(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem5: {
			caption: "Edit",
			tip: "Edit {0}",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
	},
	feditviewtoolbar_toolbar: {
		tbitem3: {
			caption: "Save",
			tip: "Save",
		},
		tbitem4: {
			caption: "Save And New",
			tip: "Save And New",
		},
		tbitem5: {
			caption: "Save And Close",
			tip: "Save And Close Window",
		},
		tbitem7: {
			caption: "Remove And Close",
			tip: "Remove And Close Window",
		},
		tbitem22: {
			caption: "Help",
			tip: "Help",
		},
	},
	fgridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "New",
			tip: "New",
		},
		tbitem8: {
			caption: "Remove",
			tip: "Remove {0}",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem13: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
};
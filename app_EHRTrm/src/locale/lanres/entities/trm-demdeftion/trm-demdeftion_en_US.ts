
export default {
  fields: {
    dcbjb: '调查表级别',
    pxbmc: '培训班名称',
    sffb: '是否发布',
    bmjzsj: '报名截止时间',
    dcscjd: '调查所处季度',
    pxjssj: '培训结束时间',
    pxdd: '培训地点',
    nd: '年度',
    createman: '建立人',
    dcdxlx: '调查对象类型',
    xh: '排序号',
    updateman: '更新人',
    pxrs: '培训人数',
    createdate: '建立时间',
    pxzynr: '培训主要内容',
    dcyglb: '调查员工类别',
    dcblx: '调查表类型',
    enable: '逻辑有效标志',
    pxkssj: '培训开始时间',
    xqfl: '需求分类',
    zdsj: '制定时间',
    updatedate: '更新时间',
    trmdemdeftionname: '培训汇总',
    pxdx: '培训对象',
    bz: '备注',
    dcjzrq: '调查截至日期',
    trmdemdeftionid: '需求调查定义标识',
    dcscnd: '调查所处年度',
    pxmk: '培训模块',
    trmtraincoursename: '培训课程',
    trmtrainfillinname: '培训项目部门填报名称',
    ormorgname: '单位',
    trmdepartname: '培训需求名称',
    pimpersonname: '员工姓名',
    ormorgid: '组织标识',
    trmtrainfillinid: '培训项目部门填报标识',
    trmtraincourseid: '培训课程标识',
    trmdepartid: '培训需求填报标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		tbfeditview: {
			caption: "培训需求填报明细",
      title: '培训需求填报明细',
		},
		pickupview: {
			caption: "培训需求汇总",
      title: '需求调查定义数据选择视图',
		},
		pickupgridview: {
			caption: "培训需求汇总",
      title: '需求调查定义选择表格视图',
		},
		tbgridview: {
			caption: "培训需求填报明细",
      title: '培训需求填报明细',
		},
		tzgridview: {
			caption: "培训需求汇总",
      title: '培训需求汇总表格视图',
		},
		tzfeditview: {
			caption: "需求汇总",
      title: '需求汇总',
		},
	},
	main_2_form: {
		details: {
			group1: "需求调查定义", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "需求调查定义标识", 
			srfmajortext: "培训汇总", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			trmdepartname: "培训需求名称", 
			trmdemdeftionname: "培训汇总", 
			pxmk: "培训模块", 
			xqfl: "需求分类", 
			pxdx: "培训对象", 
			trmtraincoursename: "培训课程", 
			pxzynr: "培训主要内容", 
			pxkssj: "培训开始时间", 
			pxjssj: "培训结束时间", 
			pxdd: "培训地点", 
			pxrs: "培训人数", 
			bmjzsj: "报名截止时间", 
			ormorgname: "单位", 
			bz: "备注", 
			trmtrainfillinid: "培训项目部门填报标识", 
			trmtraincourseid: "培训课程标识", 
			trmdemdeftionid: "需求调查定义标识", 
			ormorgid: "组织标识", 
			trmdepartid: "培训需求填报标识", 
		},
		uiactions: {
		},
	},
	main_3_form: {
		details: {
			group1: "需求调查定义", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "需求调查定义标识", 
			srfmajortext: "培训汇总", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			xh: "排序号", 
			trmdepartname: "培训需求名称", 
			trmdemdeftionname: "培训汇总", 
			pxmk: "培训模块", 
			xqfl: "需求分类", 
			pxdx: "培训对象", 
			trmtraincoursename: "培训课程", 
			pxzynr: "培训主要内容", 
			pxkssj: "培训开始时间", 
			pxjssj: "培训结束时间", 
			pxdd: "培训地点", 
			pxrs: "培训人数", 
			ormorgname: "单位", 
			bmjzsj: "报名截止时间", 
			bz: "备注", 
			trmdemdeftionid: "需求调查定义标识", 
			trmtraincourseid: "培训课程标识", 
			ormorgid: "组织标识", 
			trmdepartid: "培训需求填报标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			xh: "排序号",
			trmdemdeftionname: "培训汇总",
			pxmk: "培训模块",
			xqfl: "需求分类",
			trmtraincoursename: "培训课程",
			pxdx: "培训对象",
			pxzynr: "培训主要内容",
			pxkssj: "培训开始时间",
			pxjssj: "培训结束时间",
			pxdd: "培训地点",
			pxrs: "培训人数",
			bmjzsj: "报名截止时间",
			ormorgname: "单位",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmdemdeftionname_like: "培训汇总(%)", 
			n_pxmk_eq: "培训模块(=)", 
			n_pxkssj_gtandeq: "培训开始时间(>=)", 
			n_pxjssj_ltandeq: "培训结束时间(<=)", 
		},
		uiactions: {
		},
	},
	tbfeditviewtoolbar_toolbar: {
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
	tbgridviewtoolbar_toolbar: {
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
	tzgridviewtoolbar_toolbar: {
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
	tzfeditviewtoolbar_toolbar: {
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
};
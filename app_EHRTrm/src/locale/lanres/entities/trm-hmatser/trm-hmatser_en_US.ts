
export default {
  fields: {
    enable: "逻辑有效标志",
    createdate: "建立时间",
    trmhmatserid: "班主任标识",
    updatedate: "更新时间",
    trmhmatsername: "班主任名称",
    createman: "建立人",
    updateman: "更新人",
    lxdh: "联系方式",
    ormorgname: "所属单位",
    pimpersonname: "班主任",
    zjhm: "身份证号码",
    trmtrainagencyname: "培训机构名称",
    xb: "性别",
    nj: "年龄",
    ormorgid: "组织标识",
    trmtrainagencyid: "培训机构标识",
    pimpersonid: "人员信息标识",
  },
	views: {
		editview: {
			caption: "班主任",
      		title: "班主任编辑视图",
		},
		pickupgridview: {
			caption: "班主任",
      		title: "班主任选择表格视图",
		},
		gridview: {
			caption: "班主任",
      		title: "班主任表格视图",
		},
		mpickupview: {
			caption: "班主任",
      		title: "班主任数据多项选择视图",
		},
	},
	main_form: {
		details: {
			group1: "班主任基本信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "班主任标识", 
			srfmajortext: "班主任名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "班主任", 
			zjhm: "身份证号码", 
			xb: "性别", 
			nj: "年龄", 
			lxdh: "联系方式", 
			ormorgname: "所属单位", 
			trmhmatserid: "班主任标识", 
			pimpersonid: "人员信息标识", 
			ormorgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: "班主任",
			zjhm: "身份证号码",
			xb: "性别",
			nj: "年龄",
			lxdh: "联系方式",
			ormorgname: "所属单位",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmhmatsername_like: "班主任名称(%)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
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
	editviewtoolbar_toolbar: {
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
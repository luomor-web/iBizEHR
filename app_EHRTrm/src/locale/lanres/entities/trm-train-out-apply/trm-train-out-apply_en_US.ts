
export default {
  fields: {
    wbpxjg: "外部培训机构",
    djbh: "单据编号",
    sqrq: "申请日期",
    enable: "逻辑有效标志",
    pxfs: "培训方式",
    pxlb: "培训类别",
    pxnr: "培训内容",
    ywlx: "业务类型",
    createdate: "建立时间",
    createman: "建立人",
    pxjsrq: "培训结束日期",
    pxmb: "培训目标",
    updateman: "更新人",
    pxksrq: "培训开始日期",
    updatedate: "更新时间",
    pxdd: "培训地点",
    trmtrainoutapplyname: "外部培训申请名称",
    trmtrainoutapplyid: "外部培训申请标识",
    pimpersonname: "员工姓名",
    bm: "所在部门",
    zz: "公司",
    pimpersonid: "人员信息标识",
  },
	views: {
		pickupview: {
			caption: "外部培训申请",
      		title: "外部培训申请数据选择视图",
		},
		editview: {
			caption: "外出培训申请",
      		title: "外出培训申请",
		},
		pickupgridview: {
			caption: "外部培训申请",
      		title: "外部培训申请选择表格视图",
		},
		mpickupview: {
			caption: "外部培训申请",
      		title: "外部培训申请数据多项选择视图",
		},
		gridview: {
			caption: "外出培训申请",
      		title: "外出培训申请",
		},
	},
	main_form: {
		details: {
			group1: "外出培训申请", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "外部培训申请标识", 
			srfmajortext: "外部培训申请名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimpersonname: "申请人", 
			zz: "所属公司", 
			bm: "所属部门", 
			pimpersonid: "人员信息标识", 
			djbh: "申请编号", 
			trmtrainoutapplyname: "培训名称", 
			ywlx: "业务类型", 
			pxfs: "培训方式", 
			pxlb: "培训类别", 
			pxmb: "培训目标", 
			pxnr: "培训内容", 
			pxksrq: "培训开始日期", 
			pxjsrq: "培训结束日期", 
			pxdd: "培训地点", 
			wbpxjg: "外部培训机构", 
			trmtrainoutapplyid: "外部培训申请标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			pimpersonname: "申请人",
			zz: "所属公司",
			djbh: "申请编号",
			trmtrainoutapplyname: "参加培训名称",
			pxfs: "培训方式",
			pxnr: "培训内容",
			pxmb: "培训目标",
			pxdd: "培训地点",
			pxlb: "培训类别",
			pxksrq: "培训开始日期",
			pxjsrq: "培训结束日期",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_trmtrainoutapplyname_like: "培训名称", 
			n_pxfs_eq: "培训方式(=)", 
			n_pxlb_eq: "培训类别(=)", 
			n_ywlx_eq: "业务类型(=)", 
			n_wbpxjg_eq: "外部培训机构(=)", 
			n_pimpersonname_like: "员工姓名(%)", 
		},
		uiactions: {
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
};
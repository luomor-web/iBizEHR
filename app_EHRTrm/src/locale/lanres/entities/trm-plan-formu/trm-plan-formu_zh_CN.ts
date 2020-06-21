export default {
  fields: {
    updatedate: "更新时间",
    trmplanformuid: "培训计划制定标识",
    createdate: "建立时间",
    enable: "逻辑有效标志",
    bzsj: "编制时间",
    jd: "季度",
    pxzzf: "培训组织方",
    nd: "年度",
    createman: "建立人",
    updateman: "更新人",
    trmplanformuname: "培训计划制定名称",
    ormorgname: "填报单位",
    pimpersonname: "编制人",
    shortname: "填报部门",
    zzdzs: "填报单位",
    ormorgsectorname: "填报部门",
    ormorgid: "组织标识",
    pimpersonid: "人员信息标识",
    ormorgsectorid: "部门标识",
  },
	views: {
		pickupgridview: {
			caption: "培训计划制定",
      		title: "培训计划制定选择表格视图",
		},
		mpickupview: {
			caption: "培训计划制定",
      		title: "培训计划制定数据多项选择视图",
		},
		gridview: {
			caption: "计划制定",
      		title: "计划制定",
		},
		pickupview: {
			caption: "培训计划制定",
      		title: "培训计划制定数据选择视图",
		},
		editview: {
			caption: "培训计划",
      		title: "培训计划",
		},
	},
	main_form: {
		details: {
			group1: "培训计划", 
			druipart1: "", 
			grouppanel1: "培训计划详情", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "培训计划制定标识", 
			srfmajortext: "培训计划制定名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			trmplanformuname: "标题", 
			nd: "年度", 
			ormorgname: "填报单位", 
			ormorgsectorname: "填报部门", 
			ormorgsectorid: "部门标识", 
			ormorgid: "组织标识", 
			trmplanformuid: "培训计划制定标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			trmplanformuname: "标题",
			nd: "年度",
			zzdzs: "填报单位",
			shortname: "填报部门",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ormorgname_like: "填报单位(%)", 
			n_ormorgsectorname_like: "填报部门(%)", 
			n_nd_eq: "年度(=)", 
			n_jd_eq: "季度(=)", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem5: {
			caption: "编辑",
			tip: "编辑",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		tbitem13: {
			caption: "导出",
			tip: "导出",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem3: {
			caption: "保存",
			tip: "保存",
		},
		tbitem5: {
			caption: "保存并关闭",
			tip: "保存并关闭",
		},
	},
};
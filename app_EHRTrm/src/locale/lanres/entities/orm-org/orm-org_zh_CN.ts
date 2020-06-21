export default {
  fields: {
    btqy: "区域补贴",
    createdate: "建立时间",
    startstopsign: "启停标识",
    companyflag: "公司根组织ID",
    legalentity: "组织性质",
    ssou: "所属OU",
    updateman: "更新人",
    zzdzbm: "组织地址编码",
    gsss: "所属区域",
    levelcode: "级别编码",
    px: "排序号",
    zzcjsj: "组织创建时间",
    zzdzy: "组织地址一",
    updatedate: "更新时间",
    correspondingorg: "对应OU",
    xn: "虚拟组织",
    createman: "建立人",
    zzdze: "组织地址二",
    orgcode: "组织编号",
    orgid: "组织标识",
    zzdzs: "组织显示名称",
    shortname: "简称",
    erporgid: "ERP组织ID",
    zzlx: "组织类型",
    orgname: "组织名称",
    porgname: "上级组织",
    porgid: "组织机构标识",
  },
	views: {
		gridview: {
			caption: "组织单元管理",
      		title: "组织单元管理",
		},
		sjorgpickupview: {
			caption: "上级组织选择视图",
      		title: "上级组织选择视图",
		},
		editview: {
			caption: "组织信息",
      		title: "组织信息",
		},
		pickupview: {
			caption: "组织管理",
      		title: "组织管理数据选择视图",
		},
		sjorgpickupgridview: {
			caption: "上级组织选择视图",
      		title: "上级组织选择视图",
		},
		pickupgridview: {
			caption: "组织管理",
      		title: "组织管理选择表格视图",
		},
	},
	main_form: {
		details: {
			group1: "组织信息", 
			formpage1: "组织基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "组织标识", 
			srfmajortext: "组织名称", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			orgname: "组织名称", 
			orgcode: "组织编号", 
			shortname: "组织简称", 
			porgid: "上级组织ID", 
			porgname: "上级组织", 
			px: "排序号", 
			zzlx: "组织类型", 
			gsss: "所属区域", 
			btqy: "补贴标准", 
			ssou: "所属OU", 
			zzcjsj: "组织启用时间", 
			legalentity: "组织性质", 
			startstopsign: "启停标识", 
			correspondingorg: "对应OU", 
			xn: "虚拟组织", 
			levelcode: "级别编码", 
			erporgid: "ERP组织ID", 
			orgid: "组织标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			px: "排序号",
			orgname: "组织名称",
			shortname: "组织简称",
			orgcode: "组织编号",
			porgname: "上级组织",
			gsss: "所属区域",
			btqy: "补贴标准",
			zzcjsj: "组织启用时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_orgcode_like: "组织编号(%)", 
			n_orgname_like: "组织名称", 
			n_shortname_like: "组织简称", 
		},
		uiactions: {
		},
	},
	gridviewtoolbar2_toolbar: {
		deuiaction1: {
			caption: "新建",
			tip: "新建",
		},
		deuiaction2: {
			caption: "保存",
			tip: "保存",
		},
		deuiaction3: {
			caption: "关闭行编辑",
			tip: "关闭行编辑",
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem1_synorg: {
			caption: "同步ERP组织信息",
			tip: "从ERP系统中同步组织信息",
		},
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		deuiaction2: {
			caption: "过滤",
			tip: "过滤",
		},
		deuiaction1: {
			caption: "开启行编辑",
			tip: "开启行编辑",
		},
		tbitem16: {
			caption: "其它",
			tip: "其它",
		},
		tbitem13: {
			caption: "导出数据",
			tip: "导出数据",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
	},
	editviewtoolbar_toolbar: {
		tbitem5: {
			caption: "保存",
			tip: "保存",
		},
	},
};
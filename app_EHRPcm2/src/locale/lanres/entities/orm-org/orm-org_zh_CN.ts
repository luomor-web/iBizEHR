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
		sjyxzzpickupview: {
			caption: "组织管理",
      		title: "选择组织",
		},
		sjyxzzqxpickupgridview: {
			caption: "组织选择",
      		title: "组织选择",
		},
		sjyxzzqxpickupview: {
			caption: "组织管理",
      		title: "选择组织",
		},
		fpxxpickupview: {
			caption: "组织数据选择视图",
      		title: "组织数据选择视图",
		},
		ypzxxsypickupgridview: {
			caption: "组织选择表格视图",
      		title: "组织选择表格视图",
		},
		pickupview: {
			caption: "组织管理",
      		title: "组织管理数据选择视图",
		},
		ypzsyfpxxpickupview: {
			caption: "组织数据选择视图",
      		title: "组织数据选择视图",
		},
		mpickupview: {
			caption: "组织管理",
      		title: "组织管理数据多项选择视图",
		},
		sjyxzzpickupgridview: {
			caption: "组织选择",
      		title: "组织选择",
		},
		pickupgridview: {
			caption: "组织管理",
      		title: "组织管理选择表格视图",
		},
		fpxxpickupgridview: {
			caption: "组织选择表格视图",
      		title: "组织选择表格视图",
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
};
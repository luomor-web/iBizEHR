
export default {
  fields: {
    xmjbqk: '项目基本情况',
    updateman: '更新人',
    ordervalue: '排序号',
    qy: '补贴标准',
    edition: '版本',
    sbsj: '上班时间',
    xbsj: '下班时间',
    startstopsign: '启停标识',
    bmbzrs: '部门计划编制人数',
    createdate: '建立时间',
    bmsjbzrs: '部门实际编制人数',
    gcmcjbm: '工程名称及编码',
    xmbq: '项目标签',
    oldid: '原纪录ID',
    kqkssj: '上班考勤时间',
    orgcode: '部门编号',
    gwbzsl: '岗位编制数量',
    sjbzrs_color: '超编人数的颜色',
    jhry: '计划人月',
    approvalstatus: '审批状态',
    xccb: '相差成本(万)',
    kqjssj: '下班考勤时间',
    updatedate: '更新时间',
    xmlx: '项目类型',
    orgtype: '组织类型',
    zwbzsl: '职务编制数量',
    erporgid: 'ERP部门ID',
    dkfs: '打卡方式',
    xmlxqt: '项目类型（其他）',
    sjrs: '实际人数（部门）',
    orgsectorname: '部门名称',
    zwsl: '职务数量',
    shgwsl: '所含岗位数量',
    xmgm: '项目规模',
    xcry: '相差人月',
    gwsl: '岗位数量',
    dxmjlyq: '对项目经理的要求',
    dxmzgyq: '对项目总工的要求',
    title: '头衔',
    validflag: '启用标志',
    sjbzrs: '实际编制人数',
    referjoblevel: '参照职务层级',
    belongou: '所属OU',
    shzwsl: '所含职务数量',
    shortname: '简称',
    gqap: '工期安排',
    jhcb: '计划成本（万）',
    bmlx: '部门类型',
    xmblx: '项目部类型',
    orgsectorid: '部门标识',
    gkjz: '管控机制',
    editionstate: '版本状态',
    createman: '建立人',
    sjcb: '实际成本（万）',
    sjry: '实际人月',
    belongregion: '所属区域',
    engineeringscale: '项目规模',
    proleadername: '项目负责人',
    prodepname: '项目部名称',
    ormxmglname: '项目名称',
    pimpersonname: '部门负责人',
    orgname: '组织机构',
    zzdzs: '组织',
    xmbh: '项目编号',
    porgsectorname: '上级部门',
    pimpersonid: '部门负责人ID',
    ormxmglid: '项目ID',
    prodepid: '项目部ID',
    proleaderid: '项目负责人ID',
    porgsectorid: '上级部门ID',
    orgid: '组织机构标识',
  },
	views: {
		pickupgridview: {
			caption: "部门管理",
      title: '部门管理选择表格视图',
		},
		fpxxpickupgridview: {
			caption: "部门选择",
      title: '部门选择',
		},
		pickupview: {
			caption: "部门管理",
      title: '部门管理数据选择视图',
		},
		ydbmpickupview: {
			caption: "部门选择",
      title: '部门选择',
		},
		ydbmpickupgridview: {
			caption: "部门选择",
      title: '部门选择',
		},
		fpxxpickupview: {
			caption: "部门选择",
      title: '部门选择',
		},
	},
	bmxmjc_grid: {
		columns: {
			ordervalue: "排序",
			orgsectorname: "部门/项目",
			orgcode: "编号",
			shortname: "简称",
			orgname: "所属组织",
			belongregion: "所属区域",
			qy: "补贴标准",
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			bmlx: "类型",
			ordervalue: "排序",
			orgsectorname: "名称",
			orgcode: "编号",
			shortname: "简称",
			orgname: "所属组织",
			qy: "补贴标准",
			belongregion: "所属区域",
			startstopsign: "启停标识",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_orgname_like: "组织全称", 
			n_orgsectorname_like: "部门/项目部", 
		},
		uiactions: {
		},
	},
};
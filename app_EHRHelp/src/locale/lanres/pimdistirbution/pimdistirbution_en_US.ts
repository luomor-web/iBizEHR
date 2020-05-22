
export default {
  fields: {
    ssfw: '调动状态',
    postexpiration_color: '岗位到期颜色',
    rzjssj: '任职结束时间',
    enable: '逻辑有效标志',
    fpzt: '分配状态',
    logcontent: '日志内容',
    pimdistirbutionid: '分配信息标识',
    updateman: '更新人',
    rzkssj: '任职开始时间',
    createman: '建立人',
    yzw: '原职务',
    record: '履历说明',
    bz: '备注',
    gzdq: '工作地区',
    createdate: '建立时间',
    pimworkhistoryid: '履历id',
    orgid: '组织ID',
    isoutrecord: '外单位履历',
    pimdistirbutionname: '分配信息名称',
    updatedate: '更新时间',
    fplx: '分配',
    experience: '是否主要经历',
    jdzt: '借调状态',
    ydmxid: '异动明细id',
    postexpiration: '岗位到期（月）',
    gzdd: '工作地点',
    ygw: '原岗位',
    orgsectorid: '部门ID',
    cfplx: '类型',
    rank: '职级',
    ormpostname: '岗位',
    ygzt: '员工状态',
    xb: '性别',
    pimpersonname: '员工姓名',
    zgcode: '在岗标识',
    yzz: '原组织',
    ormorgname: '组织',
    lgnx: '岗位年限',
    ybmshortname: '原部门',
    zzmm: '政治面貌',
    ygbh: '员工编号',
    ydzt: '异动状态',
    nj: '年龄',
    yzzzzdzs: '原组织',
    ormorgsectorname: '部门',
    zzdzs: '组织',
    shortname: '部门',
    ormdutyname: '职务',
    ybm: '原部门',
    ormpostname1: '汇报关系',
    ybmid: '部门标识',
    ormorgsectorid: '部门标识',
    ormpostid1: '岗位管理标识',
    ormpostid: '岗位管理标识',
    ormdutyid: '职务管理标识',
    yzzid: '组织标识',
    ormorgid: '组织标识',
    pimpersonid: '人员信息标识',
  },
	views: {
		grpimfenpgridview: {
			caption: "分配信息",
      title: '分配信息',
		},
		grdividereditview: {
			caption: "分配信息",
      title: '分配信息',
		},
	},
	grdividereditgrid_form: {
		details: {
			group1: "分配信息", 
			formpage1: "基本信息", 
			srfupdatedate: "更新时间", 
			srforikey: "", 
			srfkey: "分配信息标识", 
			srfmajortext: "员工姓名", 
			srftempmode: "", 
			srfuf: "", 
			srfdeid: "", 
			srfsourcekey: "", 
			pimdistirbutionname: "分配信息名称", 
			pimpersonid: "人员信息标识", 
			ormorgid: "组织标识", 
			ormorgsectorid: "部门标识", 
			ormpostid: "岗位管理标识", 
			fplx: "分配", 
			fpzt: "分配状态", 
			cfplx: "类型", 
			ormorgname: "组织", 
			ormorgsectorname: "部门", 
			ormdutyname: "职务", 
			ormpostname: "岗位", 
			rzkssj: "任职开始时间", 
			rzjssj: "任职结束时间", 
			ormdutyid: "职务管理标识", 
			pimdistirbutionid: "分配信息标识", 
		},
		uiactions: {
		},
	},
	main_grid: {
		columns: {
			fplx: "分配",
			cfplx: "类型",
			zzdzs: "组织",
			shortname: "部门",
			ormdutyname: "职务",
			ormpostname: "岗位",
			rzkssj: "任职开始时间",
			rzjssj: "任职结束时间",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_ygbh_like: "员工编号", 
			n_pimpersonname_like: "员工姓名", 
			n_ormorgname_eq: "组织", 
			n_ormorgsectorname_eq: "部门", 
			n_ormdutyname_eq: "职务", 
			n_ormpostname_eq: "岗位", 
			n_fplx_eq: "分配(=)", 
			n_cfplx_eq: "类型(=)", 
			n_fpzt_eq: "分配状态(=)", 
			n_ormpostid_eq: "", 
			n_ormorgid_eq: "", 
			n_ormdutyid_eq: "", 
			n_ormorgsectorid_eq: "", 
		},
		uiactions: {
		},
	},
	grpimfenpgridviewtoolbar_toolbar: {
	},
	grdividereditviewtoolbar_toolbar: {
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
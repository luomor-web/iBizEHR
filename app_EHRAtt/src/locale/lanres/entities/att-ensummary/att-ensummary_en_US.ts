
export default {
  fields: {
    gs: "工伤假",
    ztf: "早退（分）",
    bj: "病假",
    cc: "出差",
    begindate: "开始日期",
    nd: "年度",
    nx: "年休假",
    kg: "旷工",
    yf: "月份",
    gzrjb: "工作日加班",
    js: "计划生育手术假",
    orgid: "组织ID",
    fdjrjb: "法定假日加班",
    cdf: "迟到（分）",
    ztc: "早退（次）",
    updatedate: "更新时间",
    zt: "早退",
    tcxx: "脱产学习",
    remarkreason: "部门审核并注明未签到（或缺勤）原因",
    zhts: "本月在沪出勤天数",
    enable: "逻辑有效标志",
    tx: "调休假",
    wqdts: "未签到天数",
    br: "哺乳假",
    createman: "建立人",
    updateman: "更新人",
    tq: "探亲假",
    sj: "事假",
    qq: "全勤",
    pc: "陪产假",
    sz: "丧葬假",
    cd: "迟到",
    bq: "半勤",
    createdate: "建立时间",
    orgsectorid: "部门ID",
    jh: "结婚假",
    xxrjb: "休息日加班",
    sjcqts: "本月实际出勤天数",
    attensummaryname: "考勤汇总名称",
    description: "说明",
    cj: "产假",
    qt: "其他",
    cdc: "迟到（次）",
    attensummaryid: "考勤汇总标识",
    enddate: "结束日期",
    bz: "备注",
    yq: "孕期假",
    qtdxj: "其他带薪假",
    sdt: "实到（天）",
    zw: "职务",
    ygbh: "员工编号",
    zjhm: "身份证号",
    ormorgid: "组织标识",
    ormorgname: "组织名称",
    pimpersonname: "员工姓名",
    ormorgsectorid: "部门标识",
    ormorgsectorname: "部门/项目部",
    pimpersonid: "人员信息标识",
  },
	views: {
		curzzkqhzgridview: {
			caption: "考勤汇总",
      		title: "考勤汇总",
		},
		gridview: {
			caption: "考勤汇总",
      		title: "考勤汇总",
		},
		kqhztreeexpview: {
			caption: "考勤汇总",
      		title: "考勤汇总树导航视图",
		},
	},
	main_grid: {
		columns: {
			nd: "年度",
			yf: "月份",
			pimpersonname: "员工姓名",
			ygbh: "员工编号",
			ormorgname: "组织名称",
			ormorgsectorname: "部门/项目部",
			zw: "职务",
			sdt: "实到（天）",
			cdf: "迟到（分）",
			cdc: "迟到（次）",
			ztf: "早退（分）",
			ztc: "早退（次）",
			qq: "全勤",
			cd: "迟到",
			zt: "早退",
			kg: "旷工",
			cc: "出差",
			fdjrjb: "法定假日加班",
			xxrjb: "休息日加班",
			gzrjb: "工作日加班",
			tcxx: "脱产学习",
			qt: "其他",
			nx: "年休假",
			sj: "事假",
			bj: "病假",
			tx: "调休假",
			gs: "工伤假",
			jh: "结婚假",
			yq: "孕期假",
			cj: "产假",
			pc: "陪产假",
			br: "哺乳假",
			tq: "探亲假",
			sz: "丧葬假",
			js: "计划生育手术假",
			qtdxj: "其他带薪假",
			wqdts: "未签到天数",
			zhts: "本月在沪出勤天数",
			sjcqts: "本月实际出勤天数",
			remarkreason: "部门审核并注明未签到（或缺勤）原因",
			bz: "备注",
			description: "说明",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_nd_eq: "年度(=)", 
			n_yf_eq: "月份(=)", 
			n_pimpersonname_like: "员工姓名(%)", 
		},
		uiactions: {
		},
	},
	curzzkqhzgridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
	gridviewtoolbar_toolbar: {
		deuiaction1: {
			caption: "Export",
			tip: "Export {0} Data To Excel",
		},
		tbitem23: {
			caption: "数据导入",
			tip: "数据导入",
		},
		tbitem19: {
			caption: "Filter",
			tip: "Filter",
		},
		tbitem18: {
			caption: "Help",
			tip: "Help",
		},
	},
	ormorgbmtree_treeview: {
		nodes: {
			root: "默认根节点",
		},
		uiactions: {
		},
	},
};
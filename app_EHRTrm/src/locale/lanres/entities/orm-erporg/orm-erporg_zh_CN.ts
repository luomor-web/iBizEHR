export default {
  fields: {
    orgtype: "组织类型",
    towncity: "省市",
    isenable: "是否有效",
    updateman: "更新人",
    dateto: "有效期至",
    orgaddressline1: "组织地址1",
    createman: "建立人",
    orgtypename: "组织类型释义",
    orgaddressline3: "组织地址3",
    orgaddressline2: "组织地址2",
    createdate: "建立时间",
    ormerporgid: "组织ID",
    oucode: "所属OU的组织编码",
    belongou: "所属OU的组织名称",
    lastupdatedate: "最近更新时间",
    datefrom: "有效期从",
    admcoding: "行政编码",
    yyflag: "引用标志",
    orgshortname: "组织简称",
    ormerporgname: "组织名称",
    orgcreatedate: "创建日期",
    parentorgid: "父级组织ID",
    ordernum: "组织排序编号",
    updatedate: "更新时间",
    orgzipcode: "邮编",
    ouid: "所属OU的组织ID",
    numcomp: "人数编制",
    orgcode: "组织编码",
  },
	views: {
		legalmpickupview: {
			caption: "管理单位",
      		title: "管理单位",
		},
		legalpickupgridview: {
			caption: "管理单位",
      		title: "管理单位",
		},
	},
	magunitgrid_grid: {
		columns: {
			ormerporgname: "组织名称",
			orgcode: "组织编码",
			orgtype: "组织类型",
			orgtypename: "组织类型释义",
		},
		uiactions: {
		},
	},
	default_searchform: {
		details: {
			formpage1: "常规条件", 
			n_orgcode_like: "组织编码", 
			n_ormerporgname_like: "组织名称", 
		},
		uiactions: {
		},
	},
	legalpickupgridviewtoolbar_toolbar: {
	},
};
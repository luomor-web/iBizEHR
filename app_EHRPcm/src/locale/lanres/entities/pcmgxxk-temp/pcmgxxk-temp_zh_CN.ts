export default {
  fields: {
    updatedate: "更新时间",
    createdate: "建立时间",
    updateman: "更新人",
    pcmgxxktempid: "高校学科中间表标识",
    pcmgxxktempname: "高校学科中间表名称",
    createman: "建立人",
    nd: "高校名录年度",
    nd2: "学科目录年度",
    pcmgxmlname: "高校名称",
    pcmxkmlname: "学科名称",
    pcmxkmlid: "学科目录标识",
    pcmgxmlid: "高校名录标识",
  },
	views: {
		gridview: {
			caption: "高校学科",
      		title: "高校学科",
		},
	},
	main_grid: {
		columns: {
			nd: "高校名录年度",
			pcmgxmlname: "高校名称",
			nd2: "学科目录年度",
			pcmxkmlname: "学科名称",
		},
		uiactions: {
		},
	},
	gridviewtoolbar_toolbar: {
		tbitem3: {
			caption: "新建",
			tip: "新建",
		},
		tbitem8: {
			caption: "删除",
			tip: "删除",
		},
		deuiaction1: {
			caption: "导入",
			tip: "导入",
		},
	},
};
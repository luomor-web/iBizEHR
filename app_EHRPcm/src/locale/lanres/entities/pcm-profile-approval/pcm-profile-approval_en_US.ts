
export default {
  fields: {
    pcmprofileapprovalid: "应聘者审批表标识",
    fastate: "审批阶段（非A类员工）",
    passorreject: "通过/拒绝",
    approver: "审批人",
    enable: "逻辑有效标志",
    approvaldate: "审批时间",
    approvalopinion: "审批意见",
    createdate: "建立时间",
    yjyy: "意见原因",
    createman: "建立人",
    updatedate: "更新时间",
    approvalstage: "审批阶段",
    updateman: "更新人",
    pcmprofileapprovalname: "应聘者审批表名称",
    pimbyzzjlmxname: "非A类员工编号变更",
    pcmprofilename: "姓名",
    pcmprofileid: "应聘者ID",
    pimbyzzjlmxid: "非A类员工编号变更ID",
  },
	views: {
		jjgridview: {
			caption: "应聘者审批表",
      		title: "应聘者审批表",
		},
	},
	ck_grid: {
		columns: {
			approver: "审批人",
			passorreject: "通过/拒绝",
			approvalopinion: "审批意见",
			yjyy: "意见原因",
			approvaldate: "审批时间",
		},
		uiactions: {
		},
	},
	jjgridviewtoolbar_toolbar: {
	},
};
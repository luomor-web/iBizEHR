import { MockAdapter } from '../mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取全部数组
mock.onGet('./assets/json/portlet-data.json').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status,
    [
        {"type":"appde",
    "appCodeName":"ORMORG",
    "appName":"组织管理***",
    "portletCodeName": "OrmPNumList",
    "portletName": "组织人数",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"LIST","componentName":"ormorg-orm-pnum-list-portlet"},
    {"type":"appde",
    "appCodeName":"ORMORG",
    "appName":"组织管理***",
    "portletCodeName": "OrgBar",
    "portletName": "组织分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"ormorg-org-bar-portlet"},
    {"type":"appde",
    "appCodeName":"PIMVOCATIONAL",
    "appName":"证书信息",
    "portletCodeName": "OrgVocNumList",
    "portletName": "职业资格",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"LIST","componentName":"pimvocational-org-voc-num-list-portlet"},
    {"type":"appde",
    "appCodeName":"PIMOUTPUT",
    "appName":"产值表",
    "portletCodeName": "OrgOutPutLine",
    "portletName": "月均产值",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"pimoutput-org-out-put-line-portlet"},
    {"type":"appde",
    "appCodeName":"PIMPERSON",
    "appName":"人员信息",
    "portletCodeName": "OrgPersonAgeFunnel",
    "portletName": "年龄分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"pimperson-org-person-age-funnel-portlet"},
    {"type":"appde",
    "appCodeName":"PIMPERSON",
    "appName":"人员信息",
    "portletCodeName": "OrgPersonOrgTypePie",
    "portletName": "机关与项目人员",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"pimperson-org-person-org-type-pie-portlet"},
    {"type":"app",
    "appCodeName":"PIMEDUCATION",
    "appName":"教育信息",
    "portletCodeName": "OrgEduPie",
    "portletName": "学历分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-pimeducation-org-edu-pie-portlet"},
    {"type":"app",
    "appCodeName":"PIMPERSON",
    "appName":"人员信息",
    "portletCodeName": "OrgPersonAgeFunnel",
    "portletName": "年龄分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-pimperson-org-person-age-funnel-portlet"},
    {"type":"app",
    "appCodeName":"PIMOUTPUT",
    "appName":"产值表",
    "portletCodeName": "OrgOutPutLine",
    "portletName": "月均产值",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-pimoutput-org-out-put-line-portlet"},
    {"type":"app",
    "appCodeName":"PIMPERSON",
    "appName":"人员信息",
    "portletCodeName": "OrgPersonOrgTypePie",
    "portletName": "机关与项目人员",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-pimperson-org-person-org-type-pie-portlet"},
    {"type":"app",
    "appCodeName":"ORMORG",
    "appName":"组织管理***",
    "portletCodeName": "OrmPNumList",
    "portletName": "组织人数",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"LIST","componentName":"app-ormorg-orm-pnum-list-portlet"},
    {"type":"app",
    "appCodeName":"ORMORG",
    "appName":"组织管理***",
    "portletCodeName": "OrgBar",
    "portletName": "组织分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-ormorg-org-bar-portlet"},
    {"type":"app",
    "appCodeName":"PIMVOCATIONAL",
    "appName":"证书信息",
    "portletCodeName": "OrgVocNumList",
    "portletName": "职业资格",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"LIST","componentName":"app-pimvocational-org-voc-num-list-portlet"},
    {"type":"app",
    "appCodeName":"PIMTITLE",
    "appName":"职称信息",
    "portletCodeName": "OrgTitleBar",
    "portletName": "职称分布",
    "groupCodeName":"Ungroup",
    "groupName":"（未分类）",
    "portletTYpe":"CHART","componentName":"app-pimtitle-org-title-bar-portlet"}
    ]];
});
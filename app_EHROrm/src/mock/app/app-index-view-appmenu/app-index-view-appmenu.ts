import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/app-index-viewappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '3ff154c6cf2631de6458fa56b2ee5c15',
	name: 'menuitem1',
	text: '组织管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组织管理',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/rencaixulie.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'fbcffd8a04377251a1306d64ec986718',
	name: 'menuitem3',
	text: '组织管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '组织管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/rencaixulie.png',
	textcls: '',
	appfunctag: 'Auto486',
	resourcetag: '',
},
		{
	id: '66b6adc82026f738ebec0c3a64723e31',
	name: 'menuitem2',
	text: '编制查询',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '编制查询',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/guazhidaoqiguanli.png',
	textcls: '',
	appfunctag: 'Auto468',
	resourcetag: '',
},
	],
},
            {
	id: '90DE6460-DD22-4159-8A7E-4D4541F8D87C',
	name: 'menuitem4',
	text: '标准化数据设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '标准化数据设置',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhiyezigemuluguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '184af6a08026aab3a9ca6d792da7869d',
	name: 'menuitem5',
	text: '职务设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '职务设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/zhiwuguanli.png',
	textcls: '',
	appfunctag: 'Auto461',
	resourcetag: '',
},
		{
	id: 'f77a8337aad1c2768a9c8a2af7938ced',
	name: 'menuitem9',
	text: '岗位设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '岗位设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/xuliegangweiguanxi.png',
	textcls: '',
	appfunctag: 'Auto465',
	resourcetag: '',
},
		{
	id: '2783327117d0981e84fb6292b1d007f0',
	name: 'menuitem10',
	text: '项目标签',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '项目标签',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/zzgl/1/xiangmuguanli.png',
	textcls: '',
	appfunctag: 'Auto456',
	resourcetag: '',
},
		{
	id: 'c5e4abc5f66a1415f842d99f2a1c2d44',
	name: 'menuitem11',
	text: '法人主体维护',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '法人主体维护',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/zhichengmuluguanli.png',
	textcls: '',
	appfunctag: 'Auto453',
	resourcetag: '',
},
		{
	id: '20d9f2a7f789de9d60d600e2b1a01cd8',
	name: 'menuitem12',
	text: '法人主体设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '法人主体设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinshezhi.png',
	textcls: '',
	appfunctag: 'Auto483',
	resourcetag: '',
},
	],
},
        ],
    }];
});

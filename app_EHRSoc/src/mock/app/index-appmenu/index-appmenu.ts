import { MockAdapter } from '@/mock/mock-adapter';
const mock = MockAdapter.getInstance();

import Mock from 'mockjs'
const Random = Mock.Random;

// 获取应用数据
mock.onGet('v7/indexappmenu').reply((config: any) => {
    let status = MockAdapter.mockStatus(config);
    return [status, {
        name: 'appmenu',
        items:  [
            {
	id: '4176781E-2367-44AA-ACD5-D7142B8BDA83',
	name: 'menuitem1',
	text: '社保规则',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '社保规则',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/shebaoxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: '644835C8-0CD2-4186-90A3-70E9C1A1C57C',
	name: 'menuitem2',
	text: '参保地',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保地',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/shebaoxinxi.png',
	textcls: '',
	appfunctag: '_7',
	resourcetag: '',
},
		{
	id: 'F91CFF61-8640-4CD6-8583-FB96A9FE77B3',
	name: 'menuitem3',
	text: '参保账户',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '参保账户',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gongsishebaoxinxi.png',
	textcls: '',
	appfunctag: '_6',
	resourcetag: '',
},
		{
	id: '38407974-C607-46A5-A499-D15E471F81DB',
	name: 'menuitem4',
	text: '保险类型',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '保险类型',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/jcgl/1/hetongleixing.png',
	textcls: '',
	appfunctag: '_8',
	resourcetag: '',
},
		{
	id: 'AADB29C9-9421-4371-A249-D1712D797E76',
	name: 'menuitem5',
	text: '社保规则',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '社保规则',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/kaoqinleixing.png',
	textcls: '',
	appfunctag: '_5',
	resourcetag: '',
},
	],
},
            {
	id: '3F1FC1A1-E0D5-40EE-A9E6-58C202B57A09',
	name: 'menuitem7',
	text: '社保档案',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '社保档案',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gerenshebaoxinxi.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	items: [
		{
	id: 'DFE1DFB2-9251-4B71-AD2E-52F809348191',
	name: 'menuitem6',
	text: '员工社保档案',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '员工社保档案',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/sbfl/1/gerenshebaoxinxi.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
},
		{
	id: 'AD0885B2-906A-441E-AEE2-9A62106E6192',
	name: 'menuitem8',
	text: '员工社保设置',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '员工社保设置',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: '_4',
	resourcetag: '',
},
		{
	id: 'D9B38C7D-DBDA-4F69-9200-1923E9BE3120',
	name: 'menuitem9',
	text: '非员工终止社保',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '非员工终止社保',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/guazhidaoqiguanli.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
},
	],
},
        ],
    }];
});


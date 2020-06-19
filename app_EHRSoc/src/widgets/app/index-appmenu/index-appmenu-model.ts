/**
 * Index 部件模型
 *
 * @export
 * @class IndexModel
 */
export default class IndexModel {

    /**
     * 菜单项集合
     *
     * @public
     * @type {any[]}
     * @memberof IndexModel
     */
    public items: any[] = [
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
	authtag:'EHRSoc-Index-menuitem1',
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
	authtag:'EHRSoc-Index-menuitem2',
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
	authtag:'EHRSoc-Index-menuitem3',
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
	authtag:'EHRSoc-Index-menuitem4',
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
	authtag:'EHRSoc-Index-menuitem5',
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
	authtag:'EHRSoc-Index-menuitem7',
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
	authtag:'EHRSoc-Index-menuitem6',
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
	authtag:'EHRSoc-Index-menuitem8',
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
	authtag:'EHRSoc-Index-menuitem9',
},
	],
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @public
	 * @type {any[]}
	 * @memberof IndexModel
	 */
	public funcs: any[] = [
        {
            appfunctag: '_2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'socarchivesstopgridview',
            deResParameters: [],
            routepath: '/index/:index?/socarchives/:socarchives?/stopgridview/:stopgridview?',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'stopgridview', parameterName: 'stopgridview' },
            ],
        },
        {
            appfunctag: '_8',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'soctypegridview',
            deResParameters: [],
            routepath: '/index/:index?/soctypes/:soctype?/gridview/:gridview?',
            parameters: [
                { pathName: 'soctypes', parameterName: 'soctype' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: '_6',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'socaccountgridview',
            deResParameters: [],
            routepath: '/index/:index?/socaccounts/:socaccount?/gridview/:gridview?',
            parameters: [
                { pathName: 'socaccounts', parameterName: 'socaccount' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: '_7',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'socarearoweditgridview',
            deResParameters: [],
            routepath: '/index/:index?/socareas/:socarea?/roweditgridview/:roweditgridview?',
            parameters: [
                { pathName: 'socareas', parameterName: 'socarea' },
                { pathName: 'roweditgridview', parameterName: 'roweditgridview' },
            ],
        },
        {
            appfunctag: '_5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'socrulegridview',
            deResParameters: [],
            routepath: '/index/:index?/socrules/:socrule?/gridview/:gridview?',
            parameters: [
                { pathName: 'socrules', parameterName: 'socrule' },
                { pathName: 'gridview', parameterName: 'gridview' },
            ],
        },
        {
            appfunctag: '_3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'socarchivestreeexpview',
            deResParameters: [],
            routepath: '/index/:index?/socarchives/:socarchives?/treeexpview/:treeexpview?',
            parameters: [
                { pathName: 'socarchives', parameterName: 'socarchives' },
                { pathName: 'treeexpview', parameterName: 'treeexpview' },
            ],
        },
        {
            appfunctag: '_4',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pimpersonsetsocarchivesgridview',
            deResParameters: [],
            routepath: '/index/:index?/pimpeople/:pimperson?/setsocarchivesgridview/:setsocarchivesgridview?',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'setsocarchivesgridview', parameterName: 'setsocarchivesgridview' },
            ],
        },
	];

    /**
     * 获取所有菜单项集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppMenuItems(): any[] {
        return this.items;
    }

    /**
     * 获取所有应用功能集合
     *
     * @returns {any[]}
     * @memberof IndexModel
     */
    public getAppFuncs(): any[] {
        return this.funcs;
    }
}
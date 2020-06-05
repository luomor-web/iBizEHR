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
	id: 'A18E11A6-8CAF-4A54-86FA-C014CBA7672B',
	name: 'menuitem4',
	text: '人员异动',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '人员异动',
	expanded: true,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/2/diaodongguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem4',
	items: [
		{
	id: '82339241-A705-4EC6-8072-E809C7B39152',
	name: 'menuitem1',
	text: '调动管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '调动管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/diaodongguanli.png',
	textcls: '',
	appfunctag: '_6',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem1',
},
		{
	id: 'BA8084C6-166C-481E-9384-5D1339FFF2A1',
	name: 'menuitem2',
	text: '借调管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '借调管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jiediaoguanli.png',
	textcls: '',
	appfunctag: '_4',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem2',
},
		{
	id: '197F49E7-BA8D-405C-A0A0-837219E82D9C',
	name: 'menuitem3',
	text: '兼职管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '兼职管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianzhijilu.png',
	textcls: '',
	appfunctag: '_5',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem3',
},
		{
	id: 'E0108CF4-713E-49BC-8086-999DCF02B0AB',
	name: 'menuitem7',
	text: '待岗管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '待岗管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/daigangguanli.png',
	textcls: '',
	appfunctag: '_3',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem7',
},
		{
	id: 'A6E8D8EE-0446-44EE-89EF-EC245288260D',
	name: 'menuitem8',
	text: '内退管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '内退管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/neituiguanli.png',
	textcls: '',
	appfunctag: '_7',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem8',
},
		{
	id: '1C08415A-3674-449D-AAF1-9132C826596A',
	name: 'menuitem9',
	text: '病休管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '病休管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/newimage/1/xiujiaguanli.png',
	textcls: '',
	appfunctag: '_8',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem9',
},
		{
	id: '543D3A50-4BF9-4602-8F34-ACC197D72D29',
	name: 'menuitem10',
	text: '离职管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '离职管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/lizhiguanli.png',
	textcls: '',
	appfunctag: '_2',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem10',
},
		{
	id: '962DB420-ED0C-4354-8CA6-5AD41A295AAC',
	name: 'menuitem11',
	text: '解聘管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '解聘管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jiepinguanli.png',
	textcls: '',
	appfunctag: '_10',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem11',
},
		{
	id: '812AFEB2-8721-45E1-A708-EEB06FAB18CB',
	name: 'menuitem12',
	text: '退休管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '退休管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/tuixiuguanli.png',
	textcls: '',
	appfunctag: '_9',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem12',
},
		{
	id: '36DD8AC8-9E85-4AA0-8F4C-18C01951ADB6',
	name: 'menuitem13',
	text: '试用期转正管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '试用期转正管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/shiyongqiguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem13',
},
		{
	id: '327233BA-8691-45B6-BB6B-DBA8B9F930B9',
	name: 'menuitem14',
	text: '见习生转正管理',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '见习生转正管理',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '../../../img/pzgl/1/jianxiqiguanli.png',
	textcls: '',
	appfunctag: '',
	resourcetag: '',
	authtag:'EHRPcm2-Index-menuitem14',
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
            appfunctag: '_10',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydjpmxglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydjpmxes/:pcmydjpmx?/glgridview/:glgridview?',
            parameters: [
                { pathName: 'pcmydjpmxes', parameterName: 'pcmydjpmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
            ],
        },
        {
            appfunctag: '_8',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydbxmxbxglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydbxmxes/:pcmydbxmx?/bxglgridview/:bxglgridview?',
            parameters: [
                { pathName: 'pcmydbxmxes', parameterName: 'pcmydbxmx' },
                { pathName: 'bxglgridview', parameterName: 'bxglgridview' },
            ],
        },
        {
            appfunctag: '_7',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydntmxntglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydntmxes/:pcmydntmx?/ntglgridview/:ntglgridview?',
            parameters: [
                { pathName: 'pcmydntmxes', parameterName: 'pcmydntmx' },
                { pathName: 'ntglgridview', parameterName: 'ntglgridview' },
            ],
        },
        {
            appfunctag: '_2',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydlzmxglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydlzmxes/:pcmydlzmx?/glgridview/:glgridview?',
            parameters: [
                { pathName: 'pcmydlzmxes', parameterName: 'pcmydlzmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
            ],
        },
        {
            appfunctag: '_4',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydjdmxjdglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydjdmxes/:pcmydjdmx?/jdglgridview/:jdglgridview?',
            parameters: [
                { pathName: 'pcmydjdmxes', parameterName: 'pcmydjdmx' },
                { pathName: 'jdglgridview', parameterName: 'jdglgridview' },
            ],
        },
        {
            appfunctag: '_3',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmyddgmxdgglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmyddgmxes/:pcmyddgmx?/dgglgridview/:dgglgridview?',
            parameters: [
                { pathName: 'pcmyddgmxes', parameterName: 'pcmyddgmx' },
                { pathName: 'dgglgridview', parameterName: 'dgglgridview' },
            ],
        },
        {
            appfunctag: '_9',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pimpersontxglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pimpeople/:pimperson?/txglgridview/:txglgridview?',
            parameters: [
                { pathName: 'pimpeople', parameterName: 'pimperson' },
                { pathName: 'txglgridview', parameterName: 'txglgridview' },
            ],
        },
        {
            appfunctag: '_6',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pimdistirbutionddmgrgridview',
            deResParameters: [],
            routepath: '/index/:index?/pimdistirbutions/:pimdistirbution?/ddmgrgridview/:ddmgrgridview?',
            parameters: [
                { pathName: 'pimdistirbutions', parameterName: 'pimdistirbution' },
                { pathName: 'ddmgrgridview', parameterName: 'ddmgrgridview' },
            ],
        },
        {
            appfunctag: '_5',
            appfuncyype: 'APPVIEW',
            openmode: '',
            codename: 'pcmydjzmxglgridview',
            deResParameters: [],
            routepath: '/index/:index?/pcmydjzmxes/:pcmydjzmx?/glgridview/:glgridview?',
            parameters: [
                { pathName: 'pcmydjzmxes', parameterName: 'pcmydjzmx' },
                { pathName: 'glgridview', parameterName: 'glgridview' },
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
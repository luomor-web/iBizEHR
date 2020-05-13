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
     * @private
     * @type {any[]}
     * @memberof IndexModel
     */
    private items: any[] = [
        {
	id: 'B03E7D7B-38AC-4636-AEBB-40F72477E089',
	name: 'menuitem1',
	text: '校招应聘者',
	type: 'MENUITEM',
	counterid: '',
	tooltip: '校招应聘者',
	expanded: false,
	separator: false,
	hidden: false,
	hidesidebar: false,
	opendefault: false,
	iconcls: '',
	icon: '',
	textcls: '',
	appfunctag: 'Auto499',
	resourcetag: '',
},
    ];

	/**
	 * 应用功能集合
	 *
	 * @private
	 * @type {any[]}
	 * @memberof IndexModel
	 */
	private funcs: any[] = [
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
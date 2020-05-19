/**
 * OrgVocNumList 部件模型
 *
 * @export
 * @class OrgVocNumListModel
 */
export default class OrgVocNumListModel {

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof OrgVocNumListPortlet_OrgVocNumList_listMode
	 */
	public getDataItems(): any[] {
		return [
			{
				name: 'countnum',
			},
			{
				name: 'zsmc',
			},
      {
        name:'size',
        prop:'size'
      },
      {
        name:'query',
        prop:'query'
      },
      {
        name:'page',
        prop:'page'
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
		]
	}

}